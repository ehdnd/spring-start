package ehdnd.spring_start.service;

import ehdnd.spring_start.domain.Member;
import ehdnd.spring_start.repository.MemberRepository;
import ehdnd.spring_start.repository.MemoryMemberRepository;
import java.util.List;
import java.util.Optional;

public class MemberService {

  private MemberRepository memberRepository = new MemoryMemberRepository();

  /**
   * 회원 가입
   */
  public Long join(Member member) {
    validateDuplicateMember(member);

    return memberRepository.save(member).getId();
  }

  /**
   * 중복 회원 검증
   */
  private void validateDuplicateMember(Member member) {
    memberRepository.findByName(member.getName())
        .ifPresent(m -> {
          throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
  }

  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  public Optional<Member> findOne(Long id) {
    return memberRepository.findById(id);
  }
}
