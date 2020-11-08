package com.niit.housing.converters;

import com.niit.housing.dto.ApartmentDto;
import com.niit.housing.dto.AptLocationDto;
import com.niit.housing.entity.Apartment;
import com.niit.housing.entity.AptLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ApartmentDtoToApartmentConverter implements Converter<ApartmentDto, Apartment> {
    public ConversionService conversionService;

    @Autowired
    public ApartmentDtoToApartmentConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }
    @Override
    public Apartment convert(ApartmentDto apartmentDto) {
        Apartment apartment = new Apartment();
        AptLocationDto aptLocationDto = apartmentDto.getAptLocation();
        apartment.setAccountNumber(apartmentDto.getAccountNumber());
        apartment.setTelephoneNumber(apartmentDto.getTelephoneNumber());
        apartment.setAptLocation(conversionService.convert(aptLocationDto,AptLocation.class));
        return apartment;
    }
}
