package umc.umc_study_2.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.umc_study_2.validation.validator.CheckExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckExistValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "해당하는 페이지가 존재하지 않습니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}