package com.niit.housing.converters;

import com.niit.housing.dto.UserDto;
import com.niit.housing.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserDtoToUserConverter implements Converter<UserDto, User> {
    @Override
    public User convert(UserDto userDto) {
        return new User(userDto.getFirstName(), userDto.getLastName(), userDto.getPhoneNumber());
    }
}
