package com.example.form_dang_nhap.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = Age18Validator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Age18Plus {
    String message() default "phải lớn hơn 18 tuổi";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
