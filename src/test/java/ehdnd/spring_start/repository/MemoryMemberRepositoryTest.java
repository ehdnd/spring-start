package ehdnd.spring_start.repository;

import ehdnd.spring_start.domain.Member;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

  MemoryMemberRepository repository = new MemoryMemberRepository();

  @AfterEach
  public void AfterEach() {
    repository.clearStor();
  }

  @Test
  public void save() {
    Member member = new Member();
    member.setName("Test Member");

    repository.save(member);

    Member result = repository.findById(member.getId()).get();
    assertThat(result).isEqualTo(member);
  }

  @Test
  public void findByName() {
    // given
    Member member1 = new Member();
    member1.setName("Test Member1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("Test Member2");
    repository.save(member2);

    // when
    Member result = repository.findByName("Test Member1").get();
    // then
    assertThat(result).isEqualTo(member1);
  }

  @Test
  public void findAll() {
    // given
    Member member1 = new Member();
    member1.setName("Test Member1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("Test Member2");
    repository.save(member2);

    List<Member> result = repository.findAll();
    assertThat(result).hasSize(2);
  }
}
