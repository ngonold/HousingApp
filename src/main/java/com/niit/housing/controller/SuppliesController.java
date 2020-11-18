package com.niit.housing.controller;

import com.niit.housing.dto.ConsumableSupplyDto;
import com.niit.housing.entity.ConsumableSupply;
import com.niit.housing.services.interfaces.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/consumptions")
public class SuppliesController {

    private final Validator consumableSupplyDtoValidator;
    private final SupplyService supplyService;

    @Autowired
    public SuppliesController(SupplyService supplyService, @Qualifier("consumableSupplyDtoValidator") Validator consumableSupplyDtoValidator) {
        this.supplyService = supplyService;
        this.consumableSupplyDtoValidator = consumableSupplyDtoValidator;
    }

    @GetMapping
    public List<ConsumableSupplyDto> getAllConsumptions() {
        return supplyService.getAllConsumptions();
    }

    @PostMapping
    public ConsumableSupplyDto addConsumption(@Valid @RequestBody ConsumableSupplyDto consumableSupplyDto) {
        return supplyService.addConsumption(consumableSupplyDto);
    }


}
