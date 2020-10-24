package com.niit.housing.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ApartmentDTO {
    private int aptNumber;
    private String telephoneNumber;
    private int accountNumber;
    private SuppliesConsumptionDTO suppliesConsumption;
    private AptLocationDTO aptLocation;
}
