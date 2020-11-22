package com.niit.housing.services.implementation;

import com.niit.housing.dto.ApartmentDto;
import com.niit.housing.dto.AptLocationDto;
import com.niit.housing.dto.ConsumableSupplyDto;
import com.niit.housing.entity.Apartment;
import com.niit.housing.entity.AptLocation;
import com.niit.housing.repos.ApartmentCustomRepository;
import com.niit.housing.repos.ApartmentRepository;
import com.niit.housing.services.interfaces.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentRepository apartmentRepository;
    private final ConversionService conversionService;
    private final ApartmentCustomRepository apartmentCustomRepository;

    @Autowired
    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, ConversionService conversionService,
                                ApartmentCustomRepository apartmentCustomRepository) {
        this.apartmentRepository = apartmentRepository;
        this.conversionService = conversionService;
        this.apartmentCustomRepository = apartmentCustomRepository;
    }

    @Override
    public ApartmentDto addApartment(ApartmentDto apartmentDto) {
        Apartment apartment = conversionService.convert(apartmentDto, Apartment.class);
        if (Objects.nonNull(apartment)) {
            apartmentRepository.save(apartment);
        }
        return conversionService.convert(apartment, ApartmentDto.class);
    }

    //this method is not working properly
    @Override
    public ApartmentDto updateApartment(ApartmentDto apartmentDto) {
        Apartment apartment = conversionService.convert(apartmentDto, Apartment.class);
        if (Objects.nonNull(apartment)) {
            apartmentRepository.save(apartment);
        }
        return conversionService.convert(apartment, ApartmentDto.class);
    }

    @Override
    public List<ConsumableSupplyDto> fetchGASConsumptions(Long aptId) {

        Apartment apartment = apartmentRepository.findById(aptId).get();
        return apartmentCustomRepository.fetchConsumptions(apartment).stream()
        .map(consumableSupply -> conversionService.convert(consumableSupply, ConsumableSupplyDto.class))
        .collect(Collectors.toList());

    }

//    @Override
////    public ApartmentDto addApartmentWithLocation(ApartmentDto apartmentDto, AptLocationDto aptLocationDto) {
////        Apartment apartment = conversionService.convert(apartmentDto, Apartment.class);
////        AptLocation aptLocation = conversionService.convert(aptLocationDto, AptLocation.class);
////        if (Objects.nonNull(apartment)) {
////            apartmentCustomRepository.saveApartmentWithAddress(apartment, aptLocation);
////        }
////        apartmentDto = conversionService.convert(apartment, ApartmentDto.class);
////        if (Objects.nonNull(apartmentDto)) {
////            aptLocationDto = conversionService.convert(aptLocation, AptLocationDto.class);
////            apartmentDto.setAptLocationDto(aptLocationDto);
////        }
////        return apartmentDto;
////    }


    @Override
    public void deleteApartmentById(Long id) {
        apartmentRepository.deleteById(id);
    }

    @Override
    public ApartmentDto getApartmentById(Long id) {
        Apartment apartment = new Apartment();
        if (apartmentRepository.findById(id).isPresent()) {
            apartment = apartmentRepository.findById(id).get();
        }
        //might be empty
        return conversionService.convert(apartment, ApartmentDto.class);
    }

    @Override
    public List<ApartmentDto> getAllApartments() {
        return StreamSupport.stream(apartmentRepository.findAll().spliterator(), false)
                .map(apartment -> conversionService.convert(apartment, ApartmentDto.class))
                .collect(Collectors.toList());
    }

//    @Override
//    public ApartmentDto getApartment(ApartmentDto apartmentDto) {
//        Apartment apartment = conversionService.convert(apartmentDto, Apartment.class);
//        if (Objects.nonNull(apartment)) {
//            apartmentRepository.findById();
//        }
//        return conversionService.convert(apartment, ApartmentDto.class);
//    }
}
