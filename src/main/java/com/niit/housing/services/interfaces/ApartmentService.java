package com.niit.housing.services.interfaces;

import com.niit.housing.dto.ApartmentDto;
import java.util.List;

public interface ApartmentService {
    ApartmentDto addApartment(ApartmentDto apartmentDto);
    ApartmentDto updateApartment(Long id, ApartmentDto apartmentDto);
    void deleteApartmentById(Long id);
    ApartmentDto getApartmentById(Long id);
    List<ApartmentDto> getAllApartments();
}
