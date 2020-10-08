package practice.SpringPractice.repository;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import practice.SpringPractice.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 메소드가 끝날때마다 반복
    public void afterEach() {
        repository.clearStore(); //clear
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring Boot");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("Spring Boot1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring Boot2");
        repository.save(member2);

        Member result = repository.findByName("Spring Boot1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Spring Boot1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring Boot2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}