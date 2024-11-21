package umc.umc_study_2.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umc_study_2.apiPayload.exception.handler.RegionHandler;
import umc.umc_study_2.apiPayload.code.status.ErrorStatus;
import umc.umc_study_2.converter.StoreConverter;
import umc.umc_study_2.domain.Region;
import umc.umc_study_2.domain.Review;
import umc.umc_study_2.domain.Store;
import umc.umc_study_2.repository.RegionRepository.RegionRepository;
import umc.umc_study_2.repository.StoreRepository.StoreRepository;
import umc.umc_study_2.web.dto.Store.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store addStoreToRegion(StoreRequestDTO.addStoreDTO request) {
        Store newStore = StoreConverter.toStore(request);
        Region region = regionRepository.findById(request.getRegionId()).orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        newStore.setRegion(region);
        return storeRepository.save(newStore);
    }

    @Override
    public boolean isStoreExist(Long value) {
        return storeRepository.existsById(value);
    }
}