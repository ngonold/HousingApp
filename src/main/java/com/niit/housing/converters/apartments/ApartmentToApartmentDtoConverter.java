package com.niit.housing.converters.apartments;

import com.niit.housing.dto.ApartmentDto;
import com.niit.housing.dto.AptLocationDto;
import com.niit.housing.dto.ConsumableSupplyDto;
import com.niit.housing.entity.Apartment;
import com.niit.housing.entity.AptLocation;
import com.niit.housing.entity.ConsumableSupply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApartmentToApartmentDtoConverter implements Converter<Apartment, ApartmentDto> {

    private final ConversionService conversionService;

    @Autowired
    public ApartmentToApartmentDtoConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public ApartmentDto convert(Apartment apartment) {
        AptLocation aptLocation = apartment.getAptLocation();
        List<ConsumableSupplyDto> consumableSupplyDtoList = apartment.getSuppliesConsumption()
                .stream()
                .map(consumableSupply -> conversionService.convert(consumableSupply,ConsumableSupplyDto.class))
                .collect(Collectors.toList());

        return ApartmentDto.builder()
                .accountNumber(apartment.getAccountNumber())
                .telephoneNumber(apartment.getTelephoneNumber())
                .aptLocationDto(conversionService.convert(aptLocation, AptLocationDto.class))
                .build();
    }
}
