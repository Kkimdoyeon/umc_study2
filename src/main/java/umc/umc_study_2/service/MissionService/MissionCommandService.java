package umc.umc_study_2.service.MissionService;

import umc.umc_study_2.domain.Mission;
import umc.umc_study_2.web.dto.Mission.MissionRequestDTO;

public interface MissionCommandService {
    Mission addMissionToStore(MissionRequestDTO.AddMissionDTO request);
}