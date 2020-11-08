package com.niit.housing.converters.users;

import com.niit.housing.dto.UserDto;
import com.niit.housing.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserConverter implements Converter<UserDto, User> {
    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEmail(userDto.getEmail());
        user.setUserType(userDto.getUserType());
        return user;
        //return new User(userDto.getFirstName(), userDto.getLastName(), userDto.getPhoneNumber());
    }
}