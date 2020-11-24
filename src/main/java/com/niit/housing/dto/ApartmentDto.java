package com.niit.housing.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ApartmentDto {
    private String telephoneNumber;
    private Integer accountNumber;
    //consumptions list. all consumptions of different types are stored here
    private List<ConsumableSupplyDto> consumableSuppliesDto = new ArrayList<>();
    private AptLocationDto aptLocationDto;
    private Long ownerId;
}
