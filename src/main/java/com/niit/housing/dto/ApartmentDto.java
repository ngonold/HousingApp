package com.niit.housing.dto;


import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ApartmentDto {
    private String telephoneNumber;
    private int accountNumber;
    //consumptions list. all consumptions of different types are stored here
    private List<ConsumableSupplyDto> consumableSuppliesDto;
    private AptLocationDto aptLocationDto;
}
