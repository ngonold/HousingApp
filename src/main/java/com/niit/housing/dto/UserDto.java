package com.niit.housing.dto;

import com.niit.housing.enums.UserType;
import lombok.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    //    @Email     //@Pattern(regexp = )
    private String email;
    private UserType userType = UserType.OWNER;
    private Collection<ApartmentDto> apartments = new HashSet<>();
}



