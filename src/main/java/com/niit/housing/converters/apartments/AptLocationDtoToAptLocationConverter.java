package com.niit.housing.converters.apartments;

import com.niit.housing.dto.AptLocationDto;
import com.niit.housing.entity.AptLocation;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AptLocationDtoToAptLocationConverter implements Converter<AptLocationDto, AptLocation> {

    @Override
    public AptLocation convert(AptLocationDto aptLocationDto) {
        AptLocation aptLocation = new AptLocation();
        aptLocation.setFloorNumber(aptLocationDto.getFloorNumber());
        aptLocation.setHouseNumber(aptLocationDto.getHouseNumber());
        aptLocation.setPorchNumber(aptLocationDto.getPorchNumber());
        aptLocation.setAptNumber(aptLocationDto.getAptNumber());
        aptLocation.setStreet(aptLocationDto.getStreet());
        return aptLocation;
    }
}
