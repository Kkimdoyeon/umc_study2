package umc.umc_study_2.web.dto.Mission;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.umc_study_2.domain.enums.MissionStatus;
import umc.umc_study_2.validation.annotation.ExistMember;
import umc.umc_study_2.validation.annotation.ExistMission;
import umc.umc_study_2.validation.annotation.ExistStore;

import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class AddMissionDTO {
        @ExistStore
        Long storeId;
        @NotBlank
        String mission_spec;
        @NotNull
        LocalDate deadline;
        @NotNull
        Integer reward;
    }

    @Getter
    public static class UpdateMissionStatusDTO {
        @ExistMember
        Long memberId;
        @ExistMission
        Long missionId;
        @NotNull
        MissionStatus status;
    }
}