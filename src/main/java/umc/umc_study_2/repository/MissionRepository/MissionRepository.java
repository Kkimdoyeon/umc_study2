package umc.umc_study_2.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc_study_2.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
}
