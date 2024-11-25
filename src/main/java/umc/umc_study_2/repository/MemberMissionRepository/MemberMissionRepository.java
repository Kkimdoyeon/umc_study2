package umc.umc_study_2.repository.MemberMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc_study_2.domain.Member;
import umc.umc_study_2.domain.enums.MissionStatus;
import umc.umc_study_2.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    Page<MemberMission> findAllByMemberAndStatus(Member member, MissionStatus status, PageRequest pageRequest);

    <T> Optional<T> findByMemberIdAndMissionId(Long memberId, Long missionId);
    Optional<MemberMission> findByMemberIdAndMissionIdAndStatus(Long memberId, Long missionId, MissionStatus status);

}