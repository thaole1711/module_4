package com.example.form_dang_nhap.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class Age18Validator implements ConstraintValidator<Age18Plus, LocalDate> {
    @Override
    public void initialize(Age18Plus constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext constraintValidatorContext) {
        if (date == null) {
            return false;
        }
        LocalDate today = LocalDate.now();
        return Period.between(date, today).getYears() >= 18;
    }
}
