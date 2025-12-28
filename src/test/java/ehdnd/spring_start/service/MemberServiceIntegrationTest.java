package ehdnd.spring_start.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import ehdnd.spring_start.domain.Member;
import ehdnd.spring_start.repository.MemberRepository;
import ehdnd.spring_start.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

  @Autowired
  MemberService memberService;
  @Autowired
  MemberRepository memberRepository;

  @Test
  void 회원가입() {
    // given
    Member member = new Member();
    member.setName("Hello");

    // when
    Long savedId = memberService.join(member);

    // then
    Member findMember = memberService.findOne(savedId).get();
    assertThat(member.getName()).isEqualTo(findMember.getName());
  }

  @Test
  public void 중복_회원_예외() {
    // given
    Member member1 = new Member();
    member1.setName("Hello");

    Member member2 = new Member();
    member2.setName("Hello");

    // when
    memberService.join(member1);
    IllegalStateException exception = assertThrows(IllegalStateException.class,
        () -> memberService.join(member2));

    // then
    assertThat(exception.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
  }

}