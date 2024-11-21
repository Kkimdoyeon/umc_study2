package umc.umc_study_2.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umc_study_2.apiPayload.exception.handler.MemberHandler;
import umc.umc_study_2.apiPayload.exception.handler.StoreHandler;
import umc.umc_study_2.apiPayload.code.status.ErrorStatus;
import umc.umc_study_2.converter.ReviewConverter;
import umc.umc_study_2.domain.Member;
import umc.umc_study_2.domain.Review;
import umc.umc_study_2.domain.Store;
import umc.umc_study_2.repository.MemberRepository.MemberRepository;
import umc.umc_study_2.repository.ReviewRepository.ReviewRepository;
import umc.umc_study_2.repository.StoreRepository.StoreRepository;
import umc.umc_study_2.web.dto.Review.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review addReviewToStore(ReviewRequestDTO.addReviewDTO request) {
        Review newReview = ReviewConverter.toReview(request);
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        newReview.setMember(member);
        newReview.setStore(store);
        return reviewRepository.save(newReview);
    }
}