package umc.umc_study_2.service.MissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umc_study_2.domain.enums.MissionStatus;
import umc.umc_study_2.domain.mapping.MemberMission;
import umc.umc_study_2.repository.MissionRepository.MissionRepository;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository memberMissionRepository;

    @Override
    public Optional<MemberMission> findMemberMission(Long id) {
        return memberMissionRepository.findById(id);
    }

    @Override
    public Page<MemberMission> findMissionByMemberIdAndStatus(Long memberId, MissionStatus status, Long lastMissionId, Pageable pageable) {
        Page<MemberMission> filteredMemberMissions = memberMissionRepository.dynamicQueryWithBooleanBuilder(memberId, status, lastMissionId, pageable);
        filteredMemberMissions.forEach(memberMission -> System.out.println("MemberMission: " + memberMission));
        return filteredMemberMissions;
    }
}