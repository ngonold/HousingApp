package com.niit.housing.converters.consumptions;

import com.niit.housing.dto.ConsumableSupplyDto;
import com.niit.housing.entity.ConsumableSupply;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConsumableSupplyToConsValueDto implements Converter<ConsumableSupply, ConsumableSupplyDto> {

    @Override
    public ConsumableSupplyDto convert(ConsumableSupply consumableSupply) {
        return ConsumableSupplyDto.builder()
                .month(consumableSupply.getMonth())
                .value(consumableSupply.getValue())
                .year(consumableSupply.getYear())
                .consumableType(consumableSupply.getConsumableType())
                .build();
    }

}
