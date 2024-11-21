package umc.umc_study_2.repository.ReviewRepository;

public interface ReviewRepositoryCustom {
    void dynamicQueryWithBooleanBuilder(Long memberId, Long storeId, String title, String body, float score);
}