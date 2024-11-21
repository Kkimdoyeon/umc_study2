package umc.umc_study_2.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umc_study_2.domain.Member;
import umc.umc_study_2.repository.MemberRepository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;

    @Override
    public Member findMemberById(Long id) {
        Member member = memberRepository.dynamicQueryWithBooleanBuilder(id);
        System.out.println("Member: " + member);
        return member;
    }
}
