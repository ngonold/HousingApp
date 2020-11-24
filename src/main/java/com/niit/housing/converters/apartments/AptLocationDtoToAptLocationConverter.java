package com.niit.housing.converters.apartments;

import com.niit.housing.dto.AptLocationDto;
import com.niit.housing.entity.AptLocation;
import com.niit.housing.exceptions.ApartmentNotFoundException;
import com.niit.housing.repos.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AptLocationDtoToAptLocationConverter implements Converter<AptLocationDto, AptLocation> {

    private final ApartmentRepository apartmentRepository;

    @Autowired
    public AptLocationDtoToAptLocationConverter(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public AptLocation convert(AptLocationDto aptLocationDto) {
        AptLocation aptLocation = new AptLocation();
        aptLocation.setFloorNumber(aptLocationDto.getFloorNumber());
        aptLocation.setHouseNumber(aptLocationDto.getHouseNumber());
        aptLocation.setPorchNumber(aptLocationDto.getPorchNumber());
        aptLocation.setAptNumber(aptLocationDto.getAptNumber());
        aptLocation.setStreet(aptLocationDto.getStreet());
        aptLocation.setApartment(apartmentRepository.findById(aptLocationDto.getAptId())
                .orElseThrow(() -> new ApartmentNotFoundException("Apt id = " + aptLocationDto.getAptId() + " not found")));
        return aptLocation;
    }
}
