package umc.umc_study_2.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.umc_study_2.domain.common.BaseEntity;

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ColumnDefault("0")
    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", member_id=" + (member != null ? member.getId() : "null") +
                ", store_id=" + (store != null ? store.getId() : "null") +
                ", body='" + body + '\'' +
                ", score=" + score +
                '}';
    }


    public void setMember(Member member) {
        if(this.member != null)
            this.member.getReviewList().remove(this);
        this.member = member;
        this.member.getReviewList().add(this);
    }

    public void setStore(Store store) {
        if(this.store != null)
            this.store.getReviewList().remove(this);
        this.store = store;
        this.store.getReviewList().add(this);
    }
}