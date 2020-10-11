package com.niit.housing.converters;

import com.niit.housing.dto.UserDto;
import com.niit.housing.entity.User;
import org.springframework.core.convert.converter.Converter;

public class UserToUserDtoConverter implements Converter<User, UserDto> {
    @Override
    public UserDto convert(User user) {
        return new UserDto(user.getFirstName(), user.getLastName(), user.getPhoneNumber());
    }
}
