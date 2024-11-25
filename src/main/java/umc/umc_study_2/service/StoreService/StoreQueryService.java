package umc.umc_study_2.service.StoreService;

import org.springframework.data.domain.Page;
import umc.umc_study_2.domain.Mission;
import umc.umc_study_2.domain.Review;
import umc.umc_study_2.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    Page<Review> getReviewList(Long storeId, Integer page);
    Page<Mission> getMissionList(Long storeId, Integer page);
}