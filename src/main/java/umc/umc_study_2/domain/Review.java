package umc.umc_study_2.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.umc_study_2.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Float score;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
}