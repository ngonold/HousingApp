package com.niit.housing.services.implementation;

import com.niit.housing.dto.AptLocationDto;
import com.niit.housing.entity.AptLocation;
import com.niit.housing.repos.AptLocationRepository;
import com.niit.housing.services.interfaces.AptLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AptLocationServiceImpl implements AptLocationService {

    private final ConversionService conversionService;
    private final AptLocationRepository aptLocationRepository;

    @Autowired
    public AptLocationServiceImpl(ConversionService conversionService, AptLocationRepository aptLocationRepository) {
        this.conversionService = conversionService;
        this.aptLocationRepository = aptLocationRepository;
    }

    @Override
    public AptLocationDto addAptLocation(AptLocationDto aptLocationDto) {
        AptLocation aptLocation = conversionService.convert(aptLocationDto, AptLocation.class);
        if (Objects.nonNull(aptLocation)) {
            aptLocationRepository.save(aptLocation);
        }
        return conversionService.convert(aptLocation, AptLocationDto.class);
    }

    @Override
    public AptLocationDto getAptLocation() {
        return null;
    }

    //?that probably creates another copy of new apt location... need to correct
    @Override
    public AptLocationDto updateAptLocation(AptLocationDto aptLocationDto) {
        AptLocation aptLocation = conversionService.convert(aptLocationDto, AptLocation.class);
        if (Objects.nonNull(aptLocation)) {
            aptLocationRepository.save(aptLocation);
        }
        return conversionService.convert(aptLocation, AptLocationDto.class);
    }

    @Override
    public void deleteAptLocationById(Long id) {

    }
}
