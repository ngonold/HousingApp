package com.niit.housing.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AptLocationDto {
    private String street;
    private int houseNumber;
    private int porchNumber;
    private int floorNumber;
}
