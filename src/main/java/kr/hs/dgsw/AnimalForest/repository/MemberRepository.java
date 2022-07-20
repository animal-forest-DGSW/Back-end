package kr.hs.dgsw.AnimalForest.repository;

import kr.hs.dgsw.AnimalForest.damain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByName(String name);

    boolean existsByName(String name);

    Member getMemberByName(String name);

}
