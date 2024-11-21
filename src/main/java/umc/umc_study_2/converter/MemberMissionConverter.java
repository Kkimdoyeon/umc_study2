package umc.umc_study_2.converter;

import umc.umc_study_2.domain.Member;
import umc.umc_study_2.domain.Mission;
import umc.umc_study_2.domain.mapping.MemberMission;
import umc.umc_study_2.domain.enums.MissionStatus;
import umc.umc_study_2.web.dto.MemberMission.MemberMissionRequestDTO;
import umc.umc_study_2.web.dto.MemberMission.MemberMissionResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.ChallengingResultDTO toChallengingResultDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.ChallengingResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(MemberMissionRequestDTO.ChallengingDto request, Member member, Mission mission){
        MissionStatus missionStatus = null;

        switch (request.getStatus()){
            case 1:
                missionStatus = MissionStatus.NOT_STARTED;
                break;
            case 2:
                missionStatus = MissionStatus.CHALLENGING;
                break;
            case 3:
                missionStatus = MissionStatus.COMPLETE;
                break;
        }

        return MemberMission.builder()
                .status(missionStatus)
                .member(member)
                .mission(mission)
                .build();
    }
}