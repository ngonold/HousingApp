package com.niit.housing.dto;

import com.niit.housing.enums.UserType;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class UserDto {
//    @NotBlank
    private String firstName;
//    @NotBlank
    private String lastName;
//    @NotNull(message = "blank phone number")
    private String phoneNumber;
    //    @NotNull
//    @Email     //@Pattern(regexp = )
    private String email;

    UserType userType;

    private ApartmentDto apartments;

}



