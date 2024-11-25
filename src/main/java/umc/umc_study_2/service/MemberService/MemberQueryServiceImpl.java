package umc.umc_study_2.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umc_study_2.domain.Member;
import umc.umc_study_2.domain.Review;
import umc.umc_study_2.domain.enums.MissionStatus;
import umc.umc_study_2.domain.mapping.MemberMission;
import umc.umc_study_2.repository.MemberMissionRepository.MemberMissionRepository;
import umc.umc_study_2.repository.MemberRepository.MemberRepository;
import umc.umc_study_2.repository.ReviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Member findMemberById(Long id) {
        Member member = memberRepository.dynamicQueryWithBooleanBuilder(id);
        System.out.println("Member: " + member);
        return member;
    }

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        Page<Review> memberPage = reviewRepository.findAllByMember(member,PageRequest.of(page, 10));

        return memberPage;
    }

    @Override
    public Page<MemberMission> getMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        Page<MemberMission> memberPage = memberMissionRepository.findAllByMemberAndStatus(member, MissionStatus.CHALLENGING, PageRequest.of(page - 1, 10));
        return memberPage;
    }
}