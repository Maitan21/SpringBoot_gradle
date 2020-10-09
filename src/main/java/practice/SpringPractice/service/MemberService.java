package practice.SpringPractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.SpringPractice.domain.Member;
import practice.SpringPractice.repository.MemberRepository;
import practice.SpringPractice.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;
//순수한 자바 클래스 이므로 Autowired가 인지 하지 못함
//스프링에 올라올때 이때 컨트롤뿐만 아니라 서비스도 같이 빈에 등록시켜준다.

public class MemberService {

    private  final MemberRepository memberRepository;

     public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        /*
            TODO 회원가입
            같은 이름이 있는 중복 회원x
         */
        //Optional
        validateDuplicateMember(member); // 중복 회원 검증 (Method extract)
        //result.orElseGet() //값이 있으면 꺼내와라

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
               .ifPresent(m -> {
                    throw new IllegalStateException("이미 존내하는 회원입니다.");
                });
    }

    // TODO 전체회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
