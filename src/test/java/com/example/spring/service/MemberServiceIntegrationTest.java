package com.example.spring.service;

import com.example.spring.domain.Member;
import com.example.spring.repository.MemberRepository;
import com.example.spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional // Test를 실행하기 전 트랜잭션을 하여 Test가 끝난 후에 실행했던 test의 데이터를 롤백하여 DB에 데이터를 남기지 않기때문에 반복적으로 test를 할 수 있도록 해주는 어노테이션
public class MemberServiceIntegrationTest {

        @Autowired MemberService memberService;
        @Autowired MemberRepository memberRepository;

        @Test
        void 회원가입() {
            //given
            Member member = new Member();
            member.setName("hello");

            //when
            Long saveId = memberService.join(member);

            //then
            Member findMember = memberService.findOne(saveId).get();
            Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
        }

        @Test
        public void 중복_회원_예외() {
            //given
            Member member1 = new Member();
            member1.setName("spring");

            Member member2 = new Member();
            member2.setName("spring");

            //when
            memberService.join(member1);
            IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


//        try {
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
//        }

            //then
        }

}
