package com.niit.housing.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
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
