package umc.umc_study_2.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umc_study_2.apiPayload.code.status.ErrorStatus;
import umc.umc_study_2.apiPayload.exception.handler.MemberHandler;
import umc.umc_study_2.apiPayload.exception.handler.MissionHandler;
import umc.umc_study_2.converter.MemberMissionConverter;
import umc.umc_study_2.domain.Member;
import umc.umc_study_2.domain.Mission;
import umc.umc_study_2.domain.mapping.MemberMission;
import umc.umc_study_2.repository.MemberMissionRepository.MemberMissionRepository;
import umc.umc_study_2.repository.MemberRepository.MemberRepository;
import umc.umc_study_2.repository.MissionRepository.MissionRepository;
import umc.umc_study_2.web.dto.MemberMission.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public MemberMission challengingMemberMission(MemberMissionRequestDTO.ChallengingDto request) {

        Mission mission = missionRepository.findById(request.getMission())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));


        Member member = memberRepository.findById(request.getMember())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(request, member, mission);

        return memberMissionRepository.save(newMemberMission);
    }
}