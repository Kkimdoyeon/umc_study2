package umc.umc_study_2.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc_study_2.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}