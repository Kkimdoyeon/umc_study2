package umc.umc_study_2.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1891739621L;

    public static final QMember member = new QMember("member1");

    public final umc.umc_study_2.domain.common.QBaseEntity _super = new umc.umc_study_2.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc.umc_study_2.domain.enums.Gender> gender = createEnum("gender", umc.umc_study_2.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<umc.umc_study_2.domain.mapping.MemberAgree, umc.umc_study_2.domain.mapping.QMemberAgree> memberAgreeList = this.<umc.umc_study_2.domain.mapping.MemberAgree, umc.umc_study_2.domain.mapping.QMemberAgree>createList("memberAgreeList", umc.umc_study_2.domain.mapping.MemberAgree.class, umc.umc_study_2.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final ListPath<umc.umc_study_2.domain.mapping.MemberMission, umc.umc_study_2.domain.mapping.QMemberMission> memberMissionList = this.<umc.umc_study_2.domain.mapping.MemberMission, umc.umc_study_2.domain.mapping.QMemberMission>createList("memberMissionList", umc.umc_study_2.domain.mapping.MemberMission.class, umc.umc_study_2.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<umc.umc_study_2.domain.mapping.MemberPrefer, umc.umc_study_2.domain.mapping.QMemberPrefer> memberPreferList = this.<umc.umc_study_2.domain.mapping.MemberPrefer, umc.umc_study_2.domain.mapping.QMemberPrefer>createList("memberPreferList", umc.umc_study_2.domain.mapping.MemberPrefer.class, umc.umc_study_2.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final ListPath<Notification, QNotification> notifications = this.<Notification, QNotification>createList("notifications", Notification.class, QNotification.class, PathInits.DIRECT2);

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.umc_study_2.domain.enums.SocialType> socialType = createEnum("socialType", umc.umc_study_2.domain.enums.SocialType.class);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<umc.umc_study_2.domain.enums.MemberStatus> status = createEnum("status", umc.umc_study_2.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

