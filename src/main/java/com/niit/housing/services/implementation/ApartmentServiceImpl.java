package com.niit.housing.services.implementation;

import com.niit.housing.dto.ApartmentDto;
import com.niit.housing.entity.Apartment;
import com.niit.housing.repos.ApartmentRepository;
import com.niit.housing.services.interfaces.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional(propagation = Propagation.NEVER)
public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentRepository apartmentRepository;
    private final ConversionService conversionService;

    @Autowired
    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, @Qualifier("conversionService") ConversionService conversionService) {
        this.apartmentRepository = apartmentRepository;
        this.conversionService = conversionService;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ApartmentDto addApartment(ApartmentDto apartmentDto) {
        Apartment apartment = conversionService.convert(apartmentDto, Apartment.class);
        if (Objects.nonNull(apartment)) {
            apartmentRepository.save(apartment);
        }
        return conversionService.convert(apartment, ApartmentDto.class);
    }

    //this method is not working properly
    @Override
    public ApartmentDto updateApartment(Long id, ApartmentDto apartmentDto) {
        Apartment apartmentUpdate = conversionService.convert(apartmentDto, Apartment.class);
        if (apartmentRepository.findById(id).isPresent()) {
            Apartment apartmentStored = apartmentRepository.findById(id).get();
            apartmentStored.setOwner(apartmentUpdate.getOwner());
            apartmentStored.setTelephoneNumber(apartmentUpdate.getTelephoneNumber());
            apartmentStored.setAccountNumber(apartmentUpdate.getAccountNumber());
            apartmentRepository.save(apartmentStored);
            return conversionService.convert(apartmentStored, ApartmentDto.class);
        } else {
            apartmentRepository.save(apartmentUpdate);
            return conversionService.convert(apartmentUpdate, ApartmentDto.class);
        }
    }

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
}
