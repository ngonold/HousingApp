package com.niit.housing.services.interfaces;

import com.niit.housing.dto.ConsumableSupplyDto;
import com.niit.housing.exceptions.ApartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SupplyService {
    ConsumableSupplyDto addConsumption(ConsumableSupplyDto consumableSupplyDto);
    void deleteConsumption(ConsumableSupplyDto consumableSupplyDto);
    ConsumableSupplyDto overwriteConsumption(ConsumableSupplyDto consumableSupplyDto);
    public List<ConsumableSupplyDto> getConsumptionsByAptId(Long apartmentId) throws ApartmentNotFoundException;
    public List<ConsumableSupplyDto> getAllConsumptions();
    public void deleteConsumptionByApartmentId(Long apartmentId) throws ApartmentNotFoundException;
}
