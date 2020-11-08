package com.niit.housing.converters.apartments;

import com.niit.housing.dto.AptLocationDto;
import com.niit.housing.entity.AptLocation;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class AptLocationToAptLocationDtoConverter implements Converter<AptLocation, AptLocationDto> {

    @Override
    public AptLocationDto convert(AptLocation aptLocation) {
        return AptLocationDto.builder()
                .floorNumber(aptLocation.getFloorNumber())
                .houseNumber(aptLocation.getHouseNumber())
                .porchNumber(aptLocation.getPorchNumber())
                .aptNumber(aptLocation.getAptNumber())
                .build();
    }
}
