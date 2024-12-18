package umc.umc_study_2.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.umc_study_2.apiPayload.ApiResponse;
import umc.umc_study_2.converter.MemberConverter;
import umc.umc_study_2.converter.MemberMissionConverter;
import umc.umc_study_2.domain.Member;
import umc.umc_study_2.domain.Review;
import umc.umc_study_2.domain.mapping.MemberMission;
import umc.umc_study_2.service.MemberService.MemberCommandService;
import umc.umc_study_2.service.MemberService.MemberQueryService;
import umc.umc_study_2.validation.annotation.CheckPage;
import umc.umc_study_2.validation.annotation.ExistMember;
import umc.umc_study_2.validation.annotation.ExistStore;
import umc.umc_study_2.web.dto.Member.MemberRequestDTO;
import umc.umc_study_2.web.dto.Member.MemberResponseDTO;
import umc.umc_study_2.web.dto.Mission.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "내가 작성한 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "memberId") Long storeId, @CheckPage @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = memberQueryService.getReviewList(storeId, page-1);
        return ApiResponse.onSuccess(MemberConverter.reviewPreViewListDTO(reviewList));
    }

    @GetMapping("/{memberId}/missions")
    @Operation(summary = "내가 진행 중인 미션 목록 조회 API",description = "내가 진행 중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getMissionList(@ExistMember @PathVariable(name = "memberId") Long memberId, @CheckPage @RequestParam(name = "page") Integer page) {
        Page<MemberMission> missionList = memberQueryService.getMissionList(memberId, page);
        return ApiResponse.onSuccess(MemberMissionConverter.missionPreViewListDTO(missionList));
    }
}