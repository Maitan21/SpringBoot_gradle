package practice.SpringPractice.repository;

import practice.SpringPractice.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    //TODO 회원 저장
    Member save(Member member);
    
    //TODO ID로 조회
    Optional<Member> findById(Long id);
    
    //TODO NAME로 조회
    Optional<Member> findByName(String name);
    
    //TODO 전체 조회
    List<Member> findAll();
}
