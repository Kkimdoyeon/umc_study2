package umc.umc_study_2.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.umc_study_2.validation.validator.MissionChallengedValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionChallengedValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckChallengedMission {
    String message() default "해당하는 미션은 이미 도전 중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
