package umc.umc_study_2.converter;

import umc.umc_study_2.domain.Mission;
import umc.umc_study_2.web.dto.Mission.MissionRequestDTO;
import umc.umc_study_2.web.dto.Mission.MissionResponseDTO;

import java.time.LocalDateTime;


public class MissionConverter {
    public static MissionResponseDTO.AddMissionResultDTO toAddMissionResultDTO(Mission mission) {
        return MissionResponseDTO.AddMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.AddMissionDTO request) {
        return Mission.builder()
                .missionSpec(request.getMission_spec())
                .deadline(request.getDeadline())
                .reward(request.getReward())
                .build();
    }
}