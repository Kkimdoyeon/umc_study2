package umc.umc_study_2.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.umc_study_2.apiPayload.ApiResponse;
import umc.umc_study_2.converter.ReviewConverter;
import umc.umc_study_2.domain.Review;
import umc.umc_study_2.service.ReviewService.ReviewCommandService;
import umc.umc_study_2.web.dto.Review.ReviewRequestDTO;
import umc.umc_study_2.web.dto.Review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.addReviewResultDTO> addReview(@RequestBody @Valid ReviewRequestDTO.addReviewDTO request){
        Review newReview = reviewCommandService.addReviewToStore(request);
        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResultDTO(newReview));
    }
}
