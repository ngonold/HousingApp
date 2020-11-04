package com.niit.housing.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ApartmentDto {
    private String telephoneNumber;
    private int accountNumber;
    //private SuppliesConsumptionDto suppliesConsumption;
    private AptLocationDto aptLocation;
}
