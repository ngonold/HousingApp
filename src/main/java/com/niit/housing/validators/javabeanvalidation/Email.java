package com.niit.housing.validators.javabeanvalidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//JavaBean validation
@Target(ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
public @interface Email  {
    String message()default "no email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
