package umc.umc_study_2.service.MissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.umc_study_2.domain.enums.MissionStatus;
import umc.umc_study_2.domain.mapping.MemberMission;
import java.util.Optional;

public interface MissionQueryService {
    Optional<MemberMission> findMemberMission(Long id);
    Page<MemberMission> findMissionByMemberIdAndStatus(Long memberId, MissionStatus status, Long lastMissionId, Pageable pageable);
}
