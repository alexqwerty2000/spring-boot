package com.danit.springboot.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value!=null && !value.isEmpty() && value.length() > 3;
    }

    public void initialize(ValidPassword constraintAnnotation) {

    }
}
