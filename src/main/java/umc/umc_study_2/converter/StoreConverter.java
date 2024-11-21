package umc.umc_study_2.converter;

import umc.umc_study_2.domain.Store;
import umc.umc_study_2.web.dto.Store.StoreRequestDTO;
import umc.umc_study_2.web.dto.Store.StoreResponseDTO;

public class StoreConverter {
    public static StoreResponseDTO.addStoreResultDTO toAddStoreResultDTO(Store store) {
        return StoreResponseDTO.addStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static Store toStore(StoreRequestDTO.addStore request) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }
}