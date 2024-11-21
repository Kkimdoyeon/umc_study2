package umc.umc_study_2.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umc_study_2.repository.ReviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;

    @Override
    public void insertReview(Long memberId, Long storeId, String title,String body, float score) {
        reviewRepository.dynamicQueryWithBooleanBuilder(memberId, storeId, title, body, score);
    }
}