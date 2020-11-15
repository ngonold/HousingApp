package com.niit.housing.converters.consumptions;

import com.niit.housing.dto.ConsumableSupplyDto;
import com.niit.housing.entity.ConsumableSupply;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConsumableSupplyDtoToConsumableSupply implements Converter<ConsumableSupplyDto, ConsumableSupply> {
    @Override
    public ConsumableSupply convert(ConsumableSupplyDto consumableSupplyDto) {
        ConsumableSupply consumableSupply = new ConsumableSupply();
        consumableSupply.setMonth(consumableSupplyDto.getMonth());
        consumableSupply.setValue(consumableSupplyDto.getValue());
        consumableSupply.setYear(consumableSupplyDto.getYear());
        consumableSupply.setConsumableType(consumableSupplyDto.getConsumableType());
        return consumableSupply;
    }
}
