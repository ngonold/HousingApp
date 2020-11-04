package com.niit.housing.converters;

import com.niit.housing.dto.ApartmentDto;
import com.niit.housing.entity.Apartment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ApartmentToApartmentDtoConverter implements Converter<Apartment, ApartmentDto> {

    @Override
    public ApartmentDto convert(Apartment apartment) {
        return ApartmentDto.builder()
                .accountNumber(apartment.getAccountNumber())
                .telephoneNumber(apartment.getTelephoneNumber())
//                .aptLocation(apartment.getAptLocation())
                .build();
    }
}
