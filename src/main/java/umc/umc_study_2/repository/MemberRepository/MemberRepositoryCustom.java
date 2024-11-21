package umc.umc_study_2.repository.MemberRepository;

import umc.umc_study_2.domain.Member;

public interface MemberRepositoryCustom {
    Member dynamicQueryWithBooleanBuilder(Long id);
}