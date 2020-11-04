package com.niit.housing.validators.springvalidator;

import com.niit.housing.dto.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserDtoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        final String EMAIL_REGEX = "^[A-Z0-9.+/_-]+@*.*";
        final String PHONE_REGEX = "[0-9]{10,11}";
        UserDto userDto = (UserDto) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.empty");
        //validate email here
        final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher emailMatcher = EMAIL_PATTERN.matcher(userDto.getEmail());
        if (!emailMatcher.find()) {
            errors.rejectValue("email","email.incorrect");
        }
        if (!userDto.getPhoneNumber().equals("")) {
            final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);
            Matcher phoneMatcher = PHONE_PATTERN.matcher(userDto.getPhoneNumber());
            if (!phoneMatcher.matches()) {
                errors.rejectValue("phoneNumber", "phoneNumber.incorrect");
            }
        }
    }
}
