package com.niit.housing.validators.springvalidator;

import com.niit.housing.dto.ConsumableSupplyDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.Year;
import java.time.YearMonth;

@Component
public class ConsumableSupplyDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ConsumableSupplyDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ConsumableSupplyDto consumableSupplyDto = (ConsumableSupplyDto) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "consumableType", "consumableType.mustBeDefined");
        if (consumableSupplyDto.getYear().getValue() < Year.now().getValue()) {
            errors.rejectValue("year", "year.incorrect");
        }
        if ((consumableSupplyDto.getMonth().getValue() < YearMonth.now().getMonth().getValue())
                && (consumableSupplyDto.getMonth().getValue() > 11)) {
            errors.rejectValue("month", "month.incorrect");
        }
        if (consumableSupplyDto.getValue() < 0) {
            errors.rejectValue("value", "value.incorrect");
        }
    }
}
