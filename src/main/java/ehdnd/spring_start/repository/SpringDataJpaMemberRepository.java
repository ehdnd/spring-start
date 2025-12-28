package ehdnd.spring_start.repository;

import ehdnd.spring_start.domain.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>,
    MemberRepository {

  @Override
  Optional<Member> findByName(String name);
}
