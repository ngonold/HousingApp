package com.niit.housing.controller;

import com.niit.housing.dto.ApartmentDto;
import com.niit.housing.dto.AptLocationDto;
import com.niit.housing.services.interfaces.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/apartments")
public class ApartmentController {
    ApartmentService apartmentService;
    Validator apartmentDtoValidator;

    @Autowired
    public ApartmentController(ApartmentService apartmentService, @Qualifier("apartmentDtoValidator") Validator apartmentValidator) {
        this.apartmentService = apartmentService;
        this.apartmentDtoValidator = apartmentValidator;
    }

    @GetMapping
    public List<ApartmentDto> getAllApartments() {
        return apartmentService.getAllApartments();
    }

    @GetMapping(path = "id/{id}")
    public ApartmentDto getApartmentById(@PathVariable(value = "id") Long id) {
        return apartmentService.getApartmentById(id);
    }

    @PostMapping
    public ApartmentDto addApartment(@RequestBody ApartmentDto apartmentDto) {
        return apartmentService.addApartment(apartmentDto);
    }

    @PutMapping
    public ApartmentDto updateApartment(@RequestBody ApartmentDto apartmentDto) {
        return apartmentService.updateApartment(apartmentDto);
    }

    @DeleteMapping(path = "id/{id}")
    public void deleteApartmentById(@PathVariable(value = "id") Long id) {
        apartmentService.deleteApartmentById(id);
    }

    @PostMapping(value = "/location")
    public AptLocationDto addAptLocation(AptLocationDto aptLocationDto) {
        return null;
    }

    @PutMapping(value = "/location")
    public AptLocationDto updateAptLocation(AptLocationDto aptLocationDto) {
        return null;
    }
}
