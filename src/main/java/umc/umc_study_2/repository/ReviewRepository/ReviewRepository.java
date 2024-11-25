package umc.umc_study_2.repository.ReviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc_study_2.domain.Review;
import umc.umc_study_2.domain.Store;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {

    // 메서드 이름만으로 SQL을 만들어주는 기능 활용
    // PageRequest는 페이징과 관련된 옵션 포함된 상태
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
}