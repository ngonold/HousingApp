package com.niit.housing.services.implementation;

import com.niit.housing.dto.UserDto;
import com.niit.housing.entity.User;
import com.niit.housing.repos.UserRepository;
import com.niit.housing.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
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
        User user = userRepository.findById(userId).get();
        return conversionService.convert(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        //??
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        //return userList.forEach(x->conversionService.convert(x,UserDto.class));
        List<UserDto> userDtoList = new ArrayList<>();
        for(User user : userList) {
            userDtoList.add(conversionService.convert(user, UserDto.class));
        }
        return userDtoList;
    }
}
