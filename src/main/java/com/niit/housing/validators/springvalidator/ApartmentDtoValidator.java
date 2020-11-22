package com.niit.housing.validators.springvalidator;

import com.niit.housing.dto.ApartmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class ApartmentDtoValidator implements Validator {

    private  final AptLocationDtoValidator aptLocationDtoValidator;

    @Autowired
    ApartmentDtoValidator(@Qualifier("aptLocationDtoValidator") AptLocationDtoValidator aptLocationDtoValidator) {
        this.aptLocationDtoValidator = aptLocationDtoValidator;
    }
    @Override
    public boolean supports(Class<?> clazz) {
        return ApartmentDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ApartmentDto apartmentDto = (ApartmentDto) target;
        if (apartmentDto.getAccountNumber() < 0) {
            errors.rejectValue("accountNumber","accountNumber.incorrect");
        }

        //invoke AptLocationValidator to check included info
//        ValidationUtils.invokeValidator(aptLocationDtoValidator, apartmentDto.getAptLocationDto(), errors);
    }
}
