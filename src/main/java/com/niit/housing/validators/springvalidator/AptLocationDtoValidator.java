package com.niit.housing.validators.springvalidator;

import com.niit.housing.dto.AptLocationDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AptLocationDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return AptLocationDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AptLocationDto aptLocationDto = (AptLocationDto) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"street", "street.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"houseNumber", "houseNumber.incorrect");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"aptNumber", "aptNumber.incorrect");
//        if (aptLocationDto.getHouseNumber() < 1) {
//            errors.rejectValue("houseNumber", "houseNumber.incorrect");
//        }
    }
}
