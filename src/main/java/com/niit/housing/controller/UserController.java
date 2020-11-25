package com.niit.housing.controller;

import com.niit.housing.dto.UserDto;
import com.niit.housing.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;
    private final Validator userDtoValidator;

    @Autowired
    public UserController(UserService userService, @Qualifier("userDtoValidator") Validator userDtoValidator) {
        this.userService = userService;
        this.userDtoValidator = userDtoValidator;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(userDtoValidator);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "id/{id}")
    public UserDto getUserById(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping(path = "id/{id}")
    public UserDto updateUser(@PathVariable("id") Long id, @Valid @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
    }
}
