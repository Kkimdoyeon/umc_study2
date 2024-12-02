package umc.umc_study_2.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc_study_2.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom{
    Optional<Member> findByEmail(String email);
}