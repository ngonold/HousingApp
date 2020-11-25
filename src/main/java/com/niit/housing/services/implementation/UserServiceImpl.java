package com.niit.housing.services.implementation;

import com.niit.housing.dto.UserDto;
import com.niit.housing.entity.User;
import com.niit.housing.repos.UserRepository;
import com.niit.housing.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
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

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        User userUpdate = conversionService.convert(userDto, User.class);
        if(userRepository.findById(userId).isPresent()) {
            User userStored = userRepository.findById(userId).get();
            //not sure if this should be done some other way?
            userStored.setEmail(userUpdate.getEmail());
            userStored.setFirstName(userUpdate.getFirstName());
            userStored.setLastName(userUpdate.getLastName());
            userStored.setUserType(userUpdate.getUserType());
            userRepository.save(userStored);
            return conversionService.convert(userStored, UserDto.class);
        } else {
            userRepository.save(userUpdate);
            return conversionService.convert(userUpdate, UserDto.class);
        }
    }

    @Override
    public UserDto getUser(Long userId) {
        User user = userRepository.findById(userId).get();
        return conversionService.convert(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(user -> conversionService.convert(user, UserDto.class))
                .collect(Collectors.toList());
    }
}
