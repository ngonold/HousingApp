package com.niit.housing.handlers;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ControllerAdvice
@RestController
public class ExceptHandler {
    //getting a list of non-valid arguments from controller
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FieldError> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getFieldErrors();
    }
}
