package ehdnd.spring_start;

import ehdnd.spring_start.aop.TimeTraceAop;
import ehdnd.spring_start.repository.MemberRepository;
import ehdnd.spring_start.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  private final MemberRepository memberRepository;

  @Autowired
  public SpringConfig(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository);
  }

//  @Bean
//  public TimeTraceAop timeTraceAop() {
//    return new TimeTraceAop();
//  }

}
