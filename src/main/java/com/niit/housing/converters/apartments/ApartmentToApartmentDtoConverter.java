package com.niit.housing.converters.apartments;

import com.niit.housing.dto.ApartmentDto;
import com.niit.housing.dto.AptLocationDto;
import com.niit.housing.entity.Apartment;
import com.niit.housing.entity.AptLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ApartmentToApartmentDtoConverter implements Converter<Apartment, ApartmentDto> {

    public ConversionService conversionService;

    @Autowired
    public ApartmentToApartmentDtoConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public ApartmentDto convert(Apartment apartment) {
        AptLocation aptLocation = apartment.getAptLocation();
        return ApartmentDto.builder()
                .accountNumber(apartment.getAccountNumber())
                .telephoneNumber(apartment.getTelephoneNumber())
                .aptLocationDto(conversionService.convert(aptLocation, AptLocationDto.class))
                .build();
    }
}
