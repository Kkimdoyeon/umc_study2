package umc.umc_study_2.repository.RegionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc_study_2.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}