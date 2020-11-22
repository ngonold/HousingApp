package com.niit.housing.controller;

import com.niit.housing.dto.ConsumableSupplyDto;
import com.niit.housing.entity.ConsumableSupply;
import com.niit.housing.enums.ConsumableType;
import com.niit.housing.services.interfaces.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("apartments/consumptions")
public class SuppliesController {

    private final Validator consumableSupplyDtoValidator;
    private final SupplyService supplyService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(consumableSupplyDtoValidator);
    }

    @Autowired
    public SuppliesController(SupplyService supplyService,
                              @Qualifier("consumableSupplyDtoValidator") Validator consumableSupplyDtoValidator) {
        this.supplyService = supplyService;
        this.consumableSupplyDtoValidator = consumableSupplyDtoValidator;
    }

    @GetMapping
    public List<ConsumableSupplyDto> getAllConsumptions() {
        return supplyService.getAllConsumptions();
    }

    @GetMapping(path = "id/{id}", params = {"type"})
    public Collection<ConsumableSupplyDto> getAllConsumptionsByAptIdAndType(@PathVariable("id") Long id,
                                                                            @RequestParam("type") ConsumableType type) {
        return supplyService.getConsumptionsByAptIdAndType(id, type);
    }

    @PostMapping
    public ConsumableSupplyDto addConsumption(@Valid @RequestBody ConsumableSupplyDto consumableSupplyDto) {
        return supplyService.addConsumption(consumableSupplyDto);
    }


}
