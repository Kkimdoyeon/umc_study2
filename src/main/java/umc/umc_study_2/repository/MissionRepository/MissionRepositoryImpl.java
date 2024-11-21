package umc.umc_study_2.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;
import umc.umc_study_2.domain.enums.MissionStatus;
import umc.umc_study_2.domain.mapping.MemberMission;
import umc.umc_study_2.domain.mapping.QMemberMission;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public Page<MemberMission> findMissionsByMemberIdAndStatus(Long memberId, MissionStatus status, Long lastMissionId, Pageable pageable) {
        BooleanBuilder predicate = new BooleanBuilder();

        if(memberId != null) {
            predicate.and(memberMission.member.id.eq(memberId));
        }

        if(status != null) {
            predicate.and(memberMission.status.eq(status));
        }

        if(lastMissionId != null) {
            predicate.and(memberMission.id.lt(lastMissionId));
        }

        List<MemberMission> content = jpaQueryFactory
                .selectFrom(memberMission)
                .where(predicate)
                .orderBy(memberMission.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        int total = jpaQueryFactory
                .selectFrom(memberMission)
                .where(predicate)
                .fetch().size();

        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public int findCompletedMissionCountByMemberIdAndStatus(Long memberId, MissionStatus status) {
        BooleanBuilder predicate = new BooleanBuilder();
        if(memberId != null) {
            predicate.and(memberMission.member.id.eq(memberId));
        }
        if(status != null) {
            predicate.and(memberMission.status.eq(status));
        }
        return jpaQueryFactory
                .selectFrom(memberMission)
                .where(predicate)
                .fetch().size();
    }
}