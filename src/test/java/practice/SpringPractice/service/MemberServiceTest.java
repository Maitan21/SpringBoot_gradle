package practice.SpringPractice.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import practice.SpringPractice.domain.Member;
import practice.SpringPractice.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEact() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("Spring");

        Member member2 = new Member();
        member2.setName("Spring");

        //when
        memberService.join(member1);
        /*IllegalAccessException e = assertThrows(IllegalAccessException.class, () -> memberService.join(member2));//Illegal예외가 터져야하함
        assertThat(e.getMessage()).isEqualTo("이미 존내하는 회원입니다.");*/
        /*try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존내하는 회원입니다.");
        }*/

        //then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}