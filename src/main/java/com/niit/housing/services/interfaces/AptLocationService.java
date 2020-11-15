package com.niit.housing.services.interfaces;

import com.niit.housing.dto.AptLocationDto;

public interface AptLocationService {
    AptLocationDto addAptLocation(AptLocationDto aptLocationDto);
    AptLocationDto getAptLocation();
    AptLocationDto updateAptLocation(AptLocationDto aptLocationDto);
    void deleteAptLocationById(Long id);
}
