package com.niit.housing.converters;

import com.niit.housing.dto.UserDto;
import com.niit.housing.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConverter implements Converter<User, UserDto> {
    //private final ConversionService conversionService;
    @Override
    public UserDto convert(User user) {
        //return new UserDto(user.getFirstName(), user.getLastName(), user.getPhoneNumber());
        //return conversionService.convert(user, UserDto.class);
        return UserDto.builder()
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .build();
    }
}
