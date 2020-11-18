package com.niit.housing.dto;

import com.niit.housing.enums.ConsumableType;
import lombok.*;

import java.time.Month;
import java.time.Year;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ConsumableSupplyDto {
    private Integer value;
    private ConsumableType consumableType;
    private Month month;
    private Year year;
    private Long consumptionId;
}
