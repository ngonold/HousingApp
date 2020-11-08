package com.niit.housing.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AptLocationDto {
    private String street;
    private String houseNumber;
    private String porchNumber;
    private String floorNumber;
    private String aptNumber;
}
