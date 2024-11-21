package umc.umc_study_2.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.umc_study_2.apiPayload.ApiResponse;
import umc.umc_study_2.converter.StoreConverter;
import umc.umc_study_2.domain.Store;
import umc.umc_study_2.service.StoreService.StoreCommandService;
import umc.umc_study_2.web.dto.Store.StoreRequestDTO;
import umc.umc_study_2.web.dto.Store.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.addStoreResultDTO> addStore(@RequestBody @Valid StoreRequestDTO.addStoreDTO request) {
        Store store = storeCommandService.addStoreToRegion(request);
        return ApiResponse.onSuccess(StoreConverter.toAddStoreResultDTO(store));
    }

}