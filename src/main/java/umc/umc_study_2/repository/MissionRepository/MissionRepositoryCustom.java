package umc.umc_study_2.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.umc_study_2.domain.enums.MissionStatus;
import umc.umc_study_2.domain.mapping.MemberMission;

import java.util.List;

public interface MissionRepositoryCustom {
    Page<MemberMission> dynamicQueryWithBooleanBuilder(Long memberId, MissionStatus status, Long lastMissionId, Pageable pageable);
}