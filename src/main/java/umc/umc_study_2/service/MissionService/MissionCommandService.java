package umc.umc_study_2.service.MissionService;

import umc.umc_study_2.domain.Mission;
import umc.umc_study_2.domain.enums.MissionStatus;
import umc.umc_study_2.domain.mapping.MemberMission;
import umc.umc_study_2.web.dto.Mission.MissionRequestDTO;

public interface MissionCommandService {
    Mission addMissionToStore(MissionRequestDTO.AddMissionDTO request);
    public boolean doMissionExist(Long missionId);
    MemberMission updateMissionStatus(Long memberId, Long missionId, MissionStatus status);
    }