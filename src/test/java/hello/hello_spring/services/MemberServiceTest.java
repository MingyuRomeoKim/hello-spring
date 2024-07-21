package hello.hello_spring.services;

import hello.hello_spring.domains.Member;
import hello.hello_spring.repositories.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }


    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("Mingyu");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void duplicateJoinException() {
        // given
        Member member1 = new Member();
        member1.setName("Mingyu1");

        Member member2 = new Member();
        member2.setName("Mingyu1");

        // when
        memberService.join(member1);

        // then
        IllegalStateException exception =  assertThrows(IllegalStateException.class,() -> memberService.join(member2));
        assertThat(exception.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }


    @Test
    void findMembers() {
        // given
        Member member1 = new Member();
        member1.setName("Mingyu1");

        Member member2 = new Member();
        member2.setName("Mingyu2");

        memberService.join(member1);
        memberService.join(member2);

        // when
        List<Member> result = memberService.findMembers();

        // then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void findOne() {
        // given
        Member member = new Member();
        member.setName("Mingyu");
        memberService.join(member);
        Long memberId = member.getId();

        // when
        Member result = memberService.findOne(memberId).get();

        // then
        assertThat(member.getName()).isEqualTo(result.getName());
    }
}