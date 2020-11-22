package com.niit.housing.services.interfaces;

import com.niit.housing.dto.ApartmentDto;
import com.niit.housing.dto.AptLocationDto;
import com.niit.housing.dto.ConsumableSupplyDto;

import java.util.List;

public interface ApartmentService {
    ApartmentDto addApartment(ApartmentDto apartmentDto);
    ApartmentDto updateApartment(ApartmentDto apartmentDto);
//    ApartmentDto addApartmentWithLocation(ApartmentDto apartmentDto, AptLocationDto aptLocationDto);
    //Just test!!! DELETE ME!
    List<ConsumableSupplyDto> fetchGASConsumptions(Long aptId);
    void deleteApartmentById(Long id);
    ApartmentDto getApartmentById(Long id);
    List<ApartmentDto> getAllApartments();
}
