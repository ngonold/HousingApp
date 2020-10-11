package com.niit.housing.services.interfaces;

import com.niit.housing.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    void deleteUser(Long userId);
    UserDto updateUser(UserDto userDto);
    UserDto getUser(Long userId);
    List<UserDto> getAllUsers();
}
