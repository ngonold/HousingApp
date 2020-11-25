package com.niit.housing.services.implementation;

import com.niit.housing.dto.AptLocationDto;
import com.niit.housing.entity.AptLocation;
import com.niit.housing.exceptions.ApartmentNotFoundException;
import com.niit.housing.exceptions.AptLocationNotFoundException;
import com.niit.housing.repos.ApartmentRepository;
import com.niit.housing.repos.AptLocationRepository;
import com.niit.housing.services.interfaces.AptLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class AptLocationServiceImpl implements AptLocationService {

    private final ConversionService conversionService;
    private final AptLocationRepository aptLocationRepository;
    private final ApartmentRepository apartmentRepository;

    @Autowired
    public AptLocationServiceImpl(ConversionService conversionService, AptLocationRepository aptLocationRepository,
                                  ApartmentRepository apartmentRepository) {
        this.conversionService = conversionService;
        this.aptLocationRepository = aptLocationRepository;
        this.apartmentRepository = apartmentRepository;
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
    public AptLocationDto getAptLocationByAptId(Long aptId) {
        if (apartmentRepository.findById(aptId).isPresent()) {
            return StreamSupport.stream(aptLocationRepository.findAll().spliterator(), false)
                    .filter((address) -> address.getApartment().getId().equals(aptId))
                    .map(address -> conversionService.convert(address, AptLocationDto.class))
                    .findFirst()
                    .orElseThrow(() -> new AptLocationNotFoundException("No sucaddress location"));
        } else {
            throw new ApartmentNotFoundException("Apartment id = " + aptId + " doesnt'exist");
        }
    }

    @Override
    public void deleteAptLocationById(Long id) {
        aptLocationRepository.deleteById(id);
    }
}
