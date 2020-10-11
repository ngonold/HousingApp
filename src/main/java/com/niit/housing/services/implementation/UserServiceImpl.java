package com.niit.housing.services.implementation;

import com.niit.housing.dto.UserDto;
import com.niit.housing.entity.User;
import com.niit.housing.repos.UserRepository;
import com.niit.housing.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    //@Autowire Spring Conversion service interface
    private final ConversionService conversionService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ConversionService conversionService) {
        this.userRepository = userRepository;
        this.conversionService = conversionService;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = conversionService.convert(userDto, User.class);
        user = userRepository.save(user);
        return conversionService.convert(user, UserDto.class);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    //why? 2 conversions here!
    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = conversionService.convert(userDto, User.class);
        userRepository.save(user);
        return conversionService.convert(user, UserDto.class);
    }

    @Override
    public UserDto getUser(Long userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> usersList;
        //??
        return null;
    }
}
