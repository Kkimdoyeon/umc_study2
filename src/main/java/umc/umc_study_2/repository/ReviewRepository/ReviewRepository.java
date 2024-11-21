package umc.umc_study_2.repository.ReviewRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc_study_2.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
}