package com.niit.housing.controller;

import com.niit.housing.dto.ApartmentDto;
import com.niit.housing.dto.AptLocationDto;
import com.niit.housing.dto.ConsumableSupplyDto;
import com.niit.housing.entity.ConsumableSupply;
import com.niit.housing.services.interfaces.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
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

    //DELETE ME
    @GetMapping(path = "/gas/{id}")
    public List<ConsumableSupplyDto> getGasConsumptions(@PathVariable(value = "id") Long id) {
        return apartmentService.fetchGASConsumptions(id);
    }


    @GetMapping(path = "id/{id}")
    public ApartmentDto getApartmentById(@PathVariable(value = "id") Long id) {
        return apartmentService.getApartmentById(id);
    }

    @PostMapping
    public ApartmentDto addApartment(@Valid @RequestBody ApartmentDto apartmentDto) {
        return apartmentService.addApartment(apartmentDto);
    }

    //This is wrong
//    @PostMapping(path = "/loc")
//    public ApartmentDto addApartmentWithLocation(@Valid @RequestBody ApartmentDto apartmentDto,
//                                                 @RequestBody AptLocationDto aptLocationDto) {
//        return apartmentService.addApartmentWithLocation(apartmentDto, aptLocationDto);
//    }

    @PutMapping
    public ApartmentDto updateApartment(@Valid @RequestBody ApartmentDto apartmentDto) {
        return apartmentService.updateApartment(apartmentDto);
    }

    @DeleteMapping(path = "id/{id}")
    public void deleteApartmentById(@PathVariable(value = "id") Long id) {
        apartmentService.deleteApartmentById(id);
    }
}
