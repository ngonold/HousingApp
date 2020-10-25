package com.niit.housing.handlers;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ControllerAdvice
@RestController
public class Handler {
//    @ExceptionHandler(Throwable.class)
//    public String exceptionHandler() {
//        return "ops! exception happened!";
//    }

    //getting a list of non-valid arguments from controller
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FieldError> methodArgumentNotValidExceptionHendler(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getFieldErrors();
    }
}
