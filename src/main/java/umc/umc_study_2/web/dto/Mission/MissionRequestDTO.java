package umc.umc_study_2.web.dto.Mission;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
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
        Integer price;
        @NotNull
        Integer reward;
    }
}