package umc.umc_study_2.service.StoreService;

import umc.umc_study_2.domain.Store;
import umc.umc_study_2.web.dto.Store.StoreRequestDTO;

public interface StoreCommandService {
    Store addStoreToRegion(StoreRequestDTO.addStoreDTO request);
}