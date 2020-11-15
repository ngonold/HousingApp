package com.niit.housing.converters.users;

import com.niit.housing.dto.UserDto;
import com.niit.housing.entity.Apartment;
import com.niit.housing.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class UserDtoToUserConverter implements Converter<UserDto, User> {

    private final ConversionService conversionService;

    @Autowired
    public UserDtoToUserConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        Collection<Apartment> apartmentCollection = userDto.getApartments()
                .stream()
                .map(apartmentDto -> conversionService.convert(apartmentDto, Apartment.class))
                .collect(Collectors.toList());

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEmail(userDto.getEmail());
        user.setUserType(userDto.getUserType());
        user.setApartments(apartmentCollection);
        return user;
        //return new User(userDto.getFirstName(), userDto.getLastName(), userDto.getPhoneNumber());
    }
}
