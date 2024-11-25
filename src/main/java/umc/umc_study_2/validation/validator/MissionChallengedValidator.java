package umc.umc_study_2.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.umc_study_2.apiPayload.code.status.ErrorStatus;
import umc.umc_study_2.domain.enums.MissionStatus;
import umc.umc_study_2.service.MissionService.MissionQueryService;
import umc.umc_study_2.validation.annotation.CheckChallengedMission;
import umc.umc_study_2.web.dto.Mission.MissionRequestDTO;

@Component
@RequiredArgsConstructor
public class MissionChallengedValidator implements ConstraintValidator<CheckChallengedMission, MissionRequestDTO.UpdateMissionStatusDTO> {
private final MissionQueryService missionQueryService;

    @Override
    public void initialize(CheckChallengedMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MissionRequestDTO.UpdateMissionStatusDTO value, ConstraintValidatorContext context) {
        boolean isValid = !missionQueryService.findByMemberIdAndMissionIdAndStatus(value.getMemberId(), value.getMissionId(), MissionStatus.CHALLENGING);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_CHALLENGED.toString()).addConstraintViolation();
        }
        return isValid;
    }
}