package umc.umc_study_2.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.umc_study_2.apiPayload.code.status.ErrorStatus;
import umc.umc_study_2.service.MissionService.MissionCommandServiceImpl;
import umc.umc_study_2.validation.annotation.ExistMission;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistMission, Long> {

    private final MissionCommandServiceImpl MissionCommandServiceImpl;

    @Override
    public void initialize(ExistMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            addConstraintViolation(context, "Mission cannot be null");
            return false;
        }

        boolean isValid;
        try {
            isValid = MissionCommandServiceImpl.doMissionExist(value);
        } catch (Exception e) {
            addConstraintViolation(context, ErrorStatus.MISSION_NOT_FOUND.toString());
            return false;
        }

        return isValid;

    }

    private void addConstraintViolation(ConstraintValidatorContext context, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }
}