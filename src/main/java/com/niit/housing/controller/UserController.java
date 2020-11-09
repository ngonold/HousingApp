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
        //return Arrays.asList(UserDto.builder().firstName("Nick").lastName("Gonold").build(), UserDto.builder().lastName("Gonold").firstName("Nadya").build());
        return userService.getAllUsers();
    }
    //just a test how it works
    @GetMapping(path = {"hello", "yay"})
    public String helloWorld() {
        return "Hello!";
    }
    @GetMapping(path = "id/{id}")
    public UserDto getUserById(@PathVariable("id") Long id) {
        //return UserDto.builder().firstName("John").lastName("Doe" + id).build();
        return userService.getUser(id);
    }
    @PostMapping
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }
    @PutMapping
    public UserDto updateUser(@Valid @RequestBody  UserDto userDto) {
        return userService.updateUser(userDto);
    }
    @DeleteMapping
    public void deleteUser (@RequestParam("id") Long id) {
         userService.deleteUser(id);
    }
    //not working
//    @ExceptionHandler(HttpClientErrorException.NotFound.class)
//    public String onException() {
//        return "Oops!";
//    }
}
