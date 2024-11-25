package umc.umc_study_2.converter;

import org.springframework.data.domain.Page;
import umc.umc_study_2.domain.Review;
import umc.umc_study_2.domain.Store;
import umc.umc_study_2.web.dto.Store.StoreRequestDTO;
import umc.umc_study_2.web.dto.Store.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {
    public static StoreResponseDTO.addStoreResultDTO toAddStoreResultDTO(Store store) {
        return StoreResponseDTO.addStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static Store toStore(StoreRequestDTO.addStoreDTO request) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }

    // 가게의 리뷰 목록 조회
    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                // review에 @ManyToOne으로 지정해둔 Member를 통해 아주 편하게 데이터를 가져올 수 있음
                // 객체 그래프 탐색 이라는 Spring Data JPA에서 사용 가능한 아주 강력한 기능
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    // ListDTO를 위해 리스트에 들어갈 DTO를
    // 다른 Converter에서 제작해서 이를 Java stream을 통해 DTO의 List를 만듦
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}