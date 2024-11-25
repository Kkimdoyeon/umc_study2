package umc.umc_study_2.service.MissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umc_study_2.domain.Mission;
import umc.umc_study_2.domain.enums.MissionStatus;
import umc.umc_study_2.domain.mapping.MemberMission;
import umc.umc_study_2.repository.MemberMissionRepository.MemberMissionRepository;
import umc.umc_study_2.repository.MissionRepository.MissionRepository;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;


    @Override
    public Optional<Mission> findMemberMission(Long id) {
        return missionRepository.findById(id);
    }

    @Override
    public Page<MemberMission> findMissionByMemberIdAndStatus(Long memberId, MissionStatus status, Long lastMissionId, Pageable pageable) {
        Page<MemberMission> filteredMemberMissions = missionRepository.findMissionsByMemberIdAndStatus(memberId, status, lastMissionId, pageable);
        filteredMemberMissions.forEach(memberMission -> System.out.println("MemberMission: " + memberMission));
        return filteredMemberMissions;
    }

    @Override
    public int findCompletedMissionCountByMemberIdAndStatus(Long memberId, MissionStatus status) {
        int count = missionRepository.findCompletedMissionCountByMemberIdAndStatus(memberId, status);
        System.out.println("Completed Mission Count: " + count);
        return count;
    }

    @Override
    public Page<MemberMission> findNotStartedMissionByMemberIdAndStatusAndRegionName(Long memberId, MissionStatus status, String regionName, Long lastMissionId, Pageable pageable) {
        Page<MemberMission> filteredMemberMissions = missionRepository.findNotStartedMissionByMemberIdAndStatusAndRegionName(memberId, status, regionName, lastMissionId, pageable);
        filteredMemberMissions.forEach(memberMission -> System.out.println("MemberMission: " + memberMission));
        return filteredMemberMissions;
    }

    @Override
    public boolean findByMemberIdAndMissionIdAndStatus(Long memberId, Long missionId, MissionStatus missionStatus) {
        return memberMissionRepository.findByMemberIdAndMissionIdAndStatus(memberId, missionId, missionStatus).isPresent();
    }
}