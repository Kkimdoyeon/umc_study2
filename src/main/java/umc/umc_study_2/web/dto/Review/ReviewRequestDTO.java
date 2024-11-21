package umc.umc_study_2.web.dto.Review;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.umc_study_2.validation.annotation.ExistStores;

public class ReviewRequestDTO {
    @Getter
    public static class addReviewDTO {
        @NotNull
        Long memberId;
        @ExistStores
        Long storeId;
        @NotBlank
        String body;
        @NotNull
        Float score;
    }
}