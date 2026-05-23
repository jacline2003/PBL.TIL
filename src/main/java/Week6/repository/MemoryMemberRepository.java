package com.example.pbl.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    @Override
    public void save(String name) {
        System.out.println(name + " 저장 완료");
    }
}