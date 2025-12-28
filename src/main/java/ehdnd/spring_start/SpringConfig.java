package ehdnd.spring_start;

import ehdnd.spring_start.repository.JdbcMemberRepository;
import ehdnd.spring_start.repository.JdbcTemplateMemberRepository;
import ehdnd.spring_start.repository.JpaMemberRepository;
import ehdnd.spring_start.repository.MemberRepository;
import ehdnd.spring_start.repository.MemoryMemberRepository;
import ehdnd.spring_start.service.MemberService;
import jakarta.persistence.EntityManager;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  private EntityManager em;

  @Autowired
  public SpringConfig(EntityManager em) {
    this.em = em;
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
//    return new MemoryMemberRepository();
//    return new JdbcMemberRepository(dataSource);
//    return new JdbcTemplateMemberRepository(dataSource);
    return new JpaMemberRepository(em);
  }

}
