package umc.umc_study_2.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.umc_study_2.apiPayload.code.status.ErrorStatus;
import umc.umc_study_2.validation.annotation.CheckPage;

@Component
@RequiredArgsConstructor
public class CheckExistValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer pageNum, ConstraintValidatorContext context) {
        if (pageNum == null || pageNum <= 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
