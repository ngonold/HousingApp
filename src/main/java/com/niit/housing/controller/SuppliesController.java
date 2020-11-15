package com.niit.housing.controller;

import com.niit.housing.services.interfaces.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplies")
public class SuppliesController {

    private final Validator consumableSupplyDtoValidator;
    private final SupplyService supplyService;

    @Autowired
    public SuppliesController(SupplyService supplyService, @Qualifier("consumableSupplyDtoValidator") Validator consumableSupplyDtoValidator) {
        this.supplyService = supplyService;
        this.consumableSupplyDtoValidator = consumableSupplyDtoValidator;
    }

}
