package umc.umc_study_2.service.MemberService;

import umc.umc_study_2.domain.Member;

public interface MemberQueryService {
    Member findMemberById(Long id);
}