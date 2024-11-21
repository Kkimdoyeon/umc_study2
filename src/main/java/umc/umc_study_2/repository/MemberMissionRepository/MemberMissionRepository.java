package umc.umc_study_2.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc_study_2.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}