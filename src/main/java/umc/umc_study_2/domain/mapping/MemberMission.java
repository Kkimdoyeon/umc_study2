package umc.umc_study_2.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.umc_study_2.domain.Member;
import umc.umc_study_2.domain.Mission;
import umc.umc_study_2.domain.common.BaseEntity;
import umc.umc_study_2.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;
}
