package umc.umc_study_2.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.umc_study_2.domain.Member;
import umc.umc_study_2.domain.Mission;
import umc.umc_study_2.domain.common.BaseEntity;
import umc.umc_study_2.domain.enums.MissionStatus;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(15) DEFAULT 'NOT_STARTED'")
    private MissionStatus status;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Override
    public String toString() {
        return "MemberMission{" +
                "id=" + id +
                ", name=" + mission.getStore().getName() +
                ", deadline=" + ChronoUnit.DAYS.between(LocalDate.now(), mission.getDeadline()) +
                ", reward=" + mission.getReward() +
                ", status=" + status +
                '}';
    }
}
