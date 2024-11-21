package umc.umc_study_2.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.umc_study_2.validation.validator.CategoriesExistValidator;
import umc.umc_study_2.validation.validator.StoresExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StoresExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistStores {
    String message() default "해당하는 가게가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
