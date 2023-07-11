package com.example.spring.repository;

import com.example.spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원을 저장소에 저장
    Optional<Member> findById(Long id); // id를 가져온다.
    Optional<Member> findByName(String name); // name을 가져온다.
    List<Member> findAll(); // 지금까지 저장된 모든 회원을 리스트로 가져온다.
}
