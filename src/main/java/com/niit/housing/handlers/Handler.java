package com.niit.housing.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class Handler {
    @ExceptionHandler(Throwable.class)
    public String exceptionHandler() {
        return "ops! exception happened!";
    }
}
