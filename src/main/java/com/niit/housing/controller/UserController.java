package com.niit.housing.controller;

import com.niit.housing.dto.UserDto;
import com.niit.housing.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        //return Arrays.asList(UserDto.builder().firstName("Nick").lastName("Gonold").build(), UserDto.builder().lastName("Gonold").firstName("Nadya").build());
        return userService.getAllUsers();
    }
    //just a test how it works
    @GetMapping(path = {"hello", "yay"})
    public String helloWorld() {
        return "HelloWorld!";
    }
    @GetMapping(path = "id/{id}")
    public UserDto getUserById(@PathVariable("id") Long id) {
        //return UserDto.builder().firstName("John").lastName("Doe" + id).build();
        return userService.getUser(id);
    }
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }
    @PutMapping
    public UserDto updateUser(@RequestBody  UserDto userDto) {
        return userService.updateUser(userDto);
    }
    @DeleteMapping
    public void deleteUser (@RequestParam("id") Long id) {
         userService.deleteUser(id);
    }
}
