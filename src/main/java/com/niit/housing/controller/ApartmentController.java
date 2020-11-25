package com.niit.housing.controller;

import com.niit.housing.dto.ApartmentDto;
import com.niit.housing.services.interfaces.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/apartments")
public class ApartmentController {
    private final ApartmentService apartmentService;
    private final Validator apartmentDtoValidator;

    @Autowired
    public ApartmentController(ApartmentService apartmentService, @Qualifier("apartmentDtoValidator") Validator apartmentDtoValidator) {
        this.apartmentService = apartmentService;
        this.apartmentDtoValidator = apartmentDtoValidator;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(apartmentDtoValidator);
    }

    @GetMapping
    public List<ApartmentDto> getAllApartments() {
        return apartmentService.getAllApartments();
    }

    @GetMapping(path = "id/{id}")
    public ApartmentDto getApartmentById(@PathVariable(value = "id") Long id) {
        return apartmentService.getApartmentById(id);
    }

    @PostMapping(path = "id/{id}")
    public ApartmentDto addApartment(@PathVariable("id") Long id, @Valid @RequestBody ApartmentDto apartmentDto) {
        return apartmentService.addApartment(apartmentDto);
    }

    @PutMapping(path = "id/{id}")
    public ApartmentDto updateApartment(@PathVariable("id") Long id, @Valid @RequestBody ApartmentDto apartmentDto) {
        return apartmentService.updateApartment(id, apartmentDto);
    }

    @DeleteMapping(path = "id/{id}")
    public void deleteApartmentById(@PathVariable(value = "id") Long id) {
        apartmentService.deleteApartmentById(id);
    }
}
