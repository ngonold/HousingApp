package com.niit.housing.services.implementation;

import com.google.common.collect.Iterables;
import com.niit.housing.dto.ConsumableSupplyDto;
import com.niit.housing.entity.Apartment;
import com.niit.housing.entity.ConsumableSupply;
import com.niit.housing.exceptions.ApartmentNotFoundException;
import com.niit.housing.repos.ApartmentRepository;
import com.niit.housing.repos.SupplyRepository;
import com.niit.housing.services.interfaces.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SupplyServiceImpl implements SupplyService {

    private final SupplyRepository supplyRepository;
    private final ApartmentRepository apartmentRepository;
    private final ConversionService conversionService;

    @Autowired
    public SupplyServiceImpl(SupplyRepository supplyRepository, ConversionService conversionService,
                             ApartmentRepository apartmentRepository) {
        this.supplyRepository = supplyRepository;
        this.conversionService = conversionService;
        this.apartmentRepository = apartmentRepository;
    }
    @Override
    public ConsumableSupplyDto addConsumption(ConsumableSupplyDto consumableSupplyDto) {
        ConsumableSupply consumableSupply = conversionService.convert(consumableSupplyDto, ConsumableSupply.class);
        if (Objects.nonNull(consumableSupply)) {
            supplyRepository.save(consumableSupply);
        }
        return conversionService.convert(consumableSupply, ConsumableSupplyDto.class);
    }

    @Override
    public void deleteConsumption(ConsumableSupplyDto consumableSupplyDto) {
        ConsumableSupply consumableSupply = conversionService.convert(consumableSupplyDto, ConsumableSupply.class);
        if (Objects.nonNull(consumableSupply)) {
            supplyRepository.delete(consumableSupply);
        }
    }

    @Override
    public ConsumableSupplyDto overwriteConsumption(ConsumableSupplyDto consumableSupplyDto) {
        ConsumableSupply consumableSupply = conversionService.convert(consumableSupplyDto, ConsumableSupply.class);
        if (Objects.nonNull(consumableSupply)) {
            supplyRepository.save(consumableSupply);
        }
        return conversionService.convert(consumableSupply, ConsumableSupplyDto.class);
    }

    @Override
    public List<ConsumableSupplyDto> getAllConsumptionsByAptId(Long apartmentId) throws ApartmentNotFoundException {
        Apartment apartment = apartmentRepository.findById(apartmentId).orElseThrow(ApartmentNotFoundException::new);
        return apartment.getSuppliesConsumption()
                .stream()
                .map(supply -> conversionService.convert(supply, ConsumableSupplyDto.class))
                .collect(Collectors.toList());
    }

    //If this stuff should be in ApartmentService or here?
    @Override
    public void deleteConsumptionByApartmentId(Long apartmentId) throws ApartmentNotFoundException {
        Apartment apartment = apartmentRepository.findById(apartmentId).orElseThrow(ApartmentNotFoundException::new);
        ConsumableSupply consumableSupply = Iterables.getLast(apartment.getSuppliesConsumption());
        if (Objects.nonNull(consumableSupply)) {
            supplyRepository.delete(consumableSupply);
        }
    }
}
