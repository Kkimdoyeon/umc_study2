package umc.umc_study_2.converter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import umc.umc_study_2.domain.Review;
import umc.umc_study_2.web.dto.Review.ReviewRequestDTO;
import umc.umc_study_2.web.dto.Review.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponseDTO.addReviewResultDTO toAddReviewResultDTO(Review review) {
        return ReviewResponseDTO.addReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Review toReview(ReviewRequestDTO.addReviewDTO request) {
        return Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .build();
    }
}