package umc.umc_study_2.repository.StoreRepository;

import umc.umc_study_2.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}