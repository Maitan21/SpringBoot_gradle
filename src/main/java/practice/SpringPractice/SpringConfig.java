package practice.SpringPractice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.SpringPractice.repository.MemberRepository;
import practice.SpringPractice.repository.MemoryMemberRepository;
import practice.SpringPractice.service.MemberService;

@Configuration
public class SpringConfig {

    //TODO Bean 직접 등록

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository()); //레포토지 참조객체
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
