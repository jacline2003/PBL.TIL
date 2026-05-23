package com.example.Week7.repository;

import com.example.Week7.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepository {
    private final List<Member> members = new ArrayList<>();

    public void save(Member member) {
        members.add(member);
    }

    public Optional<Member> findByName(String name) {
        return members.stream()
                .filter(m -> m.getName().equals(name))
                .findFirst();
    }

    public boolean existsByName(String name) {
        return members.stream().anyMatch(m -> m.getName().equals(name));
    }

    public void deleteByName(String name) {
        members.removeIf(m -> m.getName().equals(name));
    }
}