package umc.umc_study_2.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.umc_study_2.apiPayload.ApiResponse;
import umc.umc_study_2.converter.MemberMissionConverter;
import umc.umc_study_2.domain.mapping.MemberMission;
import umc.umc_study_2.service.MemberMissionService.MemberMissionCommandService;
import umc.umc_study_2.web.dto.MemberMission.MemberMissionRequestDTO;
import umc.umc_study_2.web.dto.MemberMission.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions/challenge")
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDTO.ChallengingResultDTO> join(@RequestBody @Valid MemberMissionRequestDTO.ChallengingDto request){
        MemberMission memberMission = memberMissionCommandService.challengingMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengingResultDTO(memberMission));
    }
}