package com.niit.housing.services.implementation;

import com.niit.housing.dto.ApartmentDto;
import com.niit.housing.entity.Apartment;
import com.niit.housing.repos.ApartmentRepository;
import com.niit.housing.services.interfaces.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentRepository apartmentRepository;
    private final ConversionService conversionService;

    @Autowired
    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, ConversionService conversionService) {
        this.apartmentRepository = apartmentRepository;
        this.conversionService = conversionService;
    }

    @Override
    public ApartmentDto addApartment(ApartmentDto apartmentDto) {
        Apartment apartment = conversionService.convert(apartmentDto, Apartment.class);
        if (Objects.nonNull(apartment)) {
            apartmentRepository.save(apartment);
        }
        return conversionService.convert(apartment, ApartmentDto.class);
    }

    @Override
    public ApartmentDto updateApartment(ApartmentDto apartmentDto) {
        Apartment apartment = conversionService.convert(apartmentDto, Apartment.class);
        if (Objects.nonNull(apartment)) {
            apartmentRepository.save(apartment);
        }
        return conversionService.convert(apartment, ApartmentDto.class);
    }

    @Override
    public ApartmentDto deleterApartment(ApartmentDto apartmentDto) {
        Apartment apartment = conversionService.convert(apartmentDto, Apartment.class);
        if (Objects.nonNull(apartment)) {
            apartmentRepository.delete(apartment);
        }
        return conversionService.convert(apartment, ApartmentDto.class);
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
        List<Apartment> allApartments = new ArrayList<>();
        List<ApartmentDto> apartmentDtoList = new ArrayList<>();
        apartmentRepository.findAll().forEach(allApartments::add);
        for (Apartment apartment : allApartments) {
            apartmentDtoList.add(conversionService.convert(apartment, ApartmentDto.class));
        }
        return apartmentDtoList;
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
