package com.niit.housing.services.interfaces;

import com.niit.housing.dto.ApartmentDto;

import java.util.List;

public interface ApartmentService {
    ApartmentDto addApartment(ApartmentDto apartmentDto);
    ApartmentDto updateApartment(ApartmentDto apartmentDto);
    ApartmentDto deleterApartment(ApartmentDto apartmentDto);
    ApartmentDto getApartmentById(Long id);
    List<ApartmentDto> getAllApartments();
}
