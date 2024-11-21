package umc.umc_study_2.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.umc_study_2.domain.*;

import java.time.LocalDate;
@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final EntityManager em;
    private final QReview review = QReview.review;
    private final QMember member = QMember.member;
    private final QStore store = QStore.store;

    @Override
    public void dynamicQueryWithBooleanBuilder(Long memberId, Long storeId, String title, String body, float score) {

        Member memberEntity = jpaQueryFactory.selectFrom(member)
                .where(member.id.eq(memberId))
                .fetchOne();

        Store storeEntity = jpaQueryFactory.selectFrom(store)
                .where(store.id.eq(storeId))
                .fetchOne();

        Review reviewEntity = Review.builder()
                .member(memberEntity)
                .store(storeEntity)
                .title(title)
                .body(body)
                .score(score)
                .build();

        em.persist(reviewEntity);
    }
}