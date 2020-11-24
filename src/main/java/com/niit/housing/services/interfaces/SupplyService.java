package com.niit.housing.services.interfaces;

import com.niit.housing.dto.ConsumableSupplyDto;
import com.niit.housing.enums.ConsumableType;
import com.niit.housing.exceptions.ApartmentNotFoundException;

import java.util.List;

public interface SupplyService {
    ConsumableSupplyDto addConsumption(ConsumableSupplyDto consumableSupplyDto);

    void deleteConsumption(ConsumableSupplyDto consumableSupplyDto);

    ConsumableSupplyDto overwriteConsumption(ConsumableSupplyDto consumableSupplyDto);

    List<ConsumableSupplyDto> getConsumptionsByAptId(Long apartmentId) throws ApartmentNotFoundException;

    List<ConsumableSupplyDto> getConsumptionsByAptIdAndType(Long apartmentId,
                                                                   ConsumableType consumableType) throws ApartmentNotFoundException;

    List<ConsumableSupplyDto> getAllConsumptions();

    void deleteConsumptionByApartmentId(Long apartmentId) throws ApartmentNotFoundException;
}
