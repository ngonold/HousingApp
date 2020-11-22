package com.niit.housing.converters.consumptions;

import com.niit.housing.dto.ConsumableSupplyDto;
import com.niit.housing.entity.Apartment;
import com.niit.housing.entity.ConsumableSupply;
import com.niit.housing.repos.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConsumableSupplyDtoToConsumableSupply implements Converter<ConsumableSupplyDto, ConsumableSupply> {

    private final ApartmentRepository apartmentRepository;

    @Autowired
    public ConsumableSupplyDtoToConsumableSupply(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public ConsumableSupply convert(ConsumableSupplyDto consumableSupplyDto) {
        Apartment apartment = apartmentRepository.findById(consumableSupplyDto.getApartmentId()).get();

        ConsumableSupply consumableSupply = new ConsumableSupply();
        consumableSupply.setMonth(consumableSupplyDto.getMonth());
        consumableSupply.setValue(consumableSupplyDto.getValue());
        consumableSupply.setYear(consumableSupplyDto.getYear());
        consumableSupply.setConsumableType(consumableSupplyDto.getConsumableType());
        consumableSupply.setApartment(apartment);
        return consumableSupply;
    }
}
