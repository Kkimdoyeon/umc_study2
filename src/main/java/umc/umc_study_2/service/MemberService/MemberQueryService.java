package umc.umc_study_2.service.MemberService;

import org.springframework.data.domain.Page;
import umc.umc_study_2.domain.Member;
import umc.umc_study_2.domain.Review;

public interface MemberQueryService {
    Member findMemberById(Long id);
    Page<Review> getReviewList(Long memberId, Integer page);
}