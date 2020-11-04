package com.niit.housing.validators.binders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//should this be deleted???
@RestController
@ControllerAdvice
public class CommonBinder {
    private final List<Validator> validators;

    @Autowired
    public CommonBinder(List<Validator> validators) {
        this.validators = validators;
    }
}
