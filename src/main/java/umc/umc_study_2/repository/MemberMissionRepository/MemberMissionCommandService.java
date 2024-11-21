package umc.umc_study_2.repository.MemberMissionRepository;

import umc.umc_study_2.domain.mapping.MemberMission;
import umc.umc_study_2.web.dto.MemberMission.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    public MemberMission challengingMemberMission(MemberMissionRequestDTO.ChallengingDto request);
}