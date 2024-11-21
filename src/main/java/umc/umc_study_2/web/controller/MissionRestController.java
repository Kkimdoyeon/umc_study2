package umc.umc_study_2.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.umc_study_2.apiPayload.ApiResponse;
import umc.umc_study_2.converter.MissionConverter;
import umc.umc_study_2.domain.Mission;
import umc.umc_study_2.service.MissionService.MissionCommandService;
import umc.umc_study_2.web.dto.Mission.MissionRequestDTO;
import umc.umc_study_2.web.dto.Mission.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.AddMissionResultDTO> addMission(@RequestBody @Valid MissionRequestDTO.AddMissionDTO reuest) {
        Mission mission = missionCommandService.addMissionToStore(reuest);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionResultDTO(mission));
    }
}