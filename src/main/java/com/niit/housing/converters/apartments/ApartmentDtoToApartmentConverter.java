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
public class ApartmentDtoToApartmentConverter implements Converter<ApartmentDto, Apartment> {
    private final ConversionService conversionService;

    @Autowired
    public ApartmentDtoToApartmentConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }
    @Override
    public Apartment convert(ApartmentDto apartmentDto) {
        //Consumption List converter
        List<ConsumableSupply> consumableSupplyList = apartmentDto.getConsumableSuppliesDto()
                .stream()
                .map(consumableSupplyDto -> conversionService.convert(consumableSupplyDto, ConsumableSupply.class))
                .collect(Collectors.toList());

        Apartment apartment = new Apartment();
        AptLocationDto aptLocationDto = apartmentDto.getAptLocationDto();
        apartment.setAccountNumber(apartmentDto.getAccountNumber());
        apartment.setTelephoneNumber(apartmentDto.getTelephoneNumber());
        apartment.setAptLocation(conversionService.convert(aptLocationDto,AptLocation.class));
        apartment.setSuppliesConsumption(consumableSupplyList);
        return apartment;
    }
}
