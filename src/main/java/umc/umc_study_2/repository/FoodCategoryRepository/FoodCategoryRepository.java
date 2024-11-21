package umc.umc_study_2.repository.FoodCategoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc_study_2.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
