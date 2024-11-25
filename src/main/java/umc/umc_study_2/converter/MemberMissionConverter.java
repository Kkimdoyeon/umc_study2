package umc.umc_study_2.converter;

import org.springframework.data.domain.Page;
import umc.umc_study_2.domain.Member;
import umc.umc_study_2.domain.Mission;
import umc.umc_study_2.domain.mapping.MemberMission;
import umc.umc_study_2.domain.enums.MissionStatus;
import umc.umc_study_2.web.dto.MemberMission.MemberMissionRequestDTO;
import umc.umc_study_2.web.dto.MemberMission.MemberMissionResponseDTO;
import umc.umc_study_2.web.dto.Mission.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.ChallengingResultDTO toChallengingResultDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.ChallengingResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(MemberMissionRequestDTO.ChallengingDto request, Member member, Mission mission){
        MissionStatus missionStatus = switch (request.getStatus()) {
            case 1 -> MissionStatus.NOT_STARTED;
            case 2 -> MissionStatus.CHALLENGING;
            case 3 -> MissionStatus.COMPLETE;
            default -> null;
        };

        return MemberMission.builder()
                .status(missionStatus)
                .member(member)
                .mission(mission)
                .build();
    }

    public static MissionResponseDTO.MissionPreViewDTO missionPreViewDTO(MemberMission mission){
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .reward(mission.getMission().getReward())
                .status(MissionStatus.CHALLENGING)
                .storeName(mission.getMission().getStore().getName())
                .deadline(mission.getMission().getDeadline())
                .missionSpec(mission.getMission().getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<MemberMission> missionList) {
        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MemberMissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}