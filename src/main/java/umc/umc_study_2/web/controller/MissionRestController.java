package umc.umc_study_2.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.umc_study_2.apiPayload.ApiResponse;
import umc.umc_study_2.converter.MemberMissionConverter;
import umc.umc_study_2.converter.MissionConverter;
import umc.umc_study_2.domain.Mission;
import umc.umc_study_2.domain.enums.MissionStatus;
import umc.umc_study_2.domain.mapping.MemberMission;
import umc.umc_study_2.service.MissionService.MissionCommandService;
import umc.umc_study_2.validation.annotation.CheckChallengedMission;
import umc.umc_study_2.web.dto.Mission.MissionRequestDTO;
import umc.umc_study_2.web.dto.Mission.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.AddMissionResultDTO> addMission(@RequestBody @Valid MissionRequestDTO.AddMissionDTO reuest) {
        Mission mission = missionCommandService.addMissionToStore(reuest);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionResultDTO(mission));
    }

    @PatchMapping("/status")
    public ApiResponse<MissionResponseDTO.UpdateMissionStatusResultDTO> challengeMission(@Valid @CheckChallengedMission MissionRequestDTO.UpdateMissionStatusDTO request) {
        MemberMission memberMission = missionCommandService.updateMissionStatus(request.getMemberId(), request.getMissionId(), MissionStatus.CHALLENGING);
        return ApiResponse.onSuccess(MemberMissionConverter.toUpdateMissionStatusResultDTO(memberMission));
    }

    @PatchMapping("/{missionId}/status")
    @Operation(summary = "진행 중인 미션 진행 완료로 바꾸기 API", description = "진행 중인 미션을 진행 완료로 바꾸는 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "missionId", description = "미션의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.UpdateMissionStatusResultDTO> completeMission(@Valid @PathVariable("missionId") Long missionId, @RequestParam("memberId") Long memberId) {
        MemberMission memberMission = missionCommandService.updateMissionStatus(memberId, missionId, MissionStatus.COMPLETE);
        return ApiResponse.onSuccess(MemberMissionConverter.toUpdateMissionStatusResultDTO(memberMission));
    }
}