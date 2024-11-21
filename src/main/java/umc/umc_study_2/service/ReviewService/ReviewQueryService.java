package umc.umc_study_2.service.ReviewService;

import umc.umc_study_2.domain.Review;
import java.time.LocalDate;
import java.util.Optional;

public interface ReviewQueryService {
    void insertReview(Long memberId, Long storeId, String title, String body, float score);
}