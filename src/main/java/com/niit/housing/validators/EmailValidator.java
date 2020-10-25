package com.niit.housing.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<Email, String> {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        Matcher emailMatcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return emailMatcher.find();
    }
}
