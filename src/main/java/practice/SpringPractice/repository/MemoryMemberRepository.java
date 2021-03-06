package practice.SpringPractice.repository;

import org.springframework.stereotype.Repository;
import practice.SpringPractice.domain.Member;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository {

    //실무에서는 동시성 문제를 고민해봐야함
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //Null가능성을 보호
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // 람다 JAVA8
                    .filter(member -> member.getName().equals(name))
                    .findAny(); //findAny() 하나라도 찾는 함수
    }

    @Override
    public List<Member> findAll() {
        //실무에서 리스트가 많이 쓰임
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
