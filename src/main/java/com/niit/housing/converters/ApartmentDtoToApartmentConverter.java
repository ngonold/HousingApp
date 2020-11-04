package com.niit.housing.converters;

import com.niit.housing.dto.ApartmentDto;
import com.niit.housing.entity.Apartment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ApartmentDtoToApartmentConverter implements Converter<ApartmentDto, Apartment> {

    @Override
    public Apartment convert(ApartmentDto apartmentDto) {
        Apartment apartment = new Apartment();
        apartment.setAccountNumber(apartmentDto.getAccountNumber());
        apartment.setTelephoneNumber(apartmentDto.getTelephoneNumber());
//        apartment.setAptLocation(apartment.getAptLocation());
        return apartment;
    }
}
