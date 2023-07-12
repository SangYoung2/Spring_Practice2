package com.example.spring.repository;

import com.example.spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository //repository는 데이터를 저장하는 장소이다.
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //findAny는 하나라도 찾아지면 바로 반복을 끝낸다.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store안에 member들을 전부 가져온다.
    }

    public void clearStore() {
        store.clear();
    }
}
