package umc.umc_study_2.web.dto.MemberMission;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.umc_study_2.validation.annotation.ExistMember;
import umc.umc_study_2.validation.annotation.ExistMission;

public class MemberMissionRequestDTO {

    @Getter
    public static class ChallengingDto{
        @NotNull
        Integer status;
        @ExistMission
        Long mission;
        @ExistMember
        Long member;
    }
}