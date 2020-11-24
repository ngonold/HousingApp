package com.niit.housing.controller;

import com.niit.housing.dto.AptLocationDto;
import com.niit.housing.services.implementation.AptLocationServiceImpl;
import com.niit.housing.services.interfaces.AptLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/apartments/locations")
public class AptLocationController {

    private final AptLocationService locationService;
    private final Validator aptLocationDtoValidator;

    @Autowired
    public AptLocationController(AptLocationServiceImpl locationService,
                                 @Qualifier("aptLocationDtoValidator") Validator aptLocationDtoValidator) {
        this.locationService = locationService;
        this.aptLocationDtoValidator = aptLocationDtoValidator;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(aptLocationDtoValidator);
    }

    @GetMapping(path = "id/{id}")
    public AptLocationDto getAptLocationByApartmentId(@PathVariable("id") Long id) {
        return locationService.getAptLocationByAptId(id);
    }

    @PostMapping
    public AptLocationDto addAptLocation(@Valid @RequestBody AptLocationDto aptLocationDto) {
        return locationService.addAptLocation(aptLocationDto);
    }

    @PutMapping
    public AptLocationDto updateAptLocation(@Valid @RequestBody AptLocationDto aptLocationDto) {
        return locationService.updateAptLocation(aptLocationDto);
    }

    @DeleteMapping(path = "id/{id}")
    public void deleteAptLocationById(@PathVariable("id") Long id) {
        locationService.deleteAptLocationById(id);
    }
}
