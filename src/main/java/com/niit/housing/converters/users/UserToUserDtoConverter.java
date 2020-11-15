package com.niit.housing.converters.users;

import com.niit.housing.dto.ApartmentDto;
import com.niit.housing.dto.UserDto;
import com.niit.housing.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class UserToUserDtoConverter implements Converter<User, UserDto> {

    private final ConversionService conversionService;

    @Autowired
    public UserToUserDtoConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }
    @Override
    public UserDto convert(User user) {
        Collection<ApartmentDto> apartmentDtoCollection = user.getApartments()
                .stream()
                .map(apartment -> conversionService.convert(user.getApartments(), ApartmentDto.class))
                .collect(Collectors.toList());
        return UserDto.builder()
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .userType(user.getUserType())
                .apartments(apartmentDtoCollection)
                .build();
    }
}
