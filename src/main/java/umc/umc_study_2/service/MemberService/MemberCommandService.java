package umc.umc_study_2.service.MemberService;

import umc.umc_study_2.domain.Member;
import umc.umc_study_2.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
