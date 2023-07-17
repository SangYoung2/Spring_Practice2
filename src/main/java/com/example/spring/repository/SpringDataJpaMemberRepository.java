package com.example.spring.repository;

import com.example.spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    // JpaRepository<>를 extends 하면 자동으로 @Bean으로 등록을 해준다.
    @Override
    Optional<Member> findByName(String name);
}
