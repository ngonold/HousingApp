package com.niit.housing.dto;

import com.niit.housing.validators.Email;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}



