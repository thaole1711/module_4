package com.example.thong_tin_bai_hat.validator;

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
