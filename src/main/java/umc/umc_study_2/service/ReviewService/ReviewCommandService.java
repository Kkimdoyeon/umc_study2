package umc.umc_study_2.service.ReviewService;

import umc.umc_study_2.domain.Review;
import umc.umc_study_2.web.dto.Review.ReviewRequestDTO;

public interface ReviewCommandService {
    Review addReviewToStore(ReviewRequestDTO.addReviewDTO request);
}