package com.example.Week7.repository;

import com.example.Week7.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<엔티티 타입, PK 타입> 상속
// → save(), findById(), findAll(), deleteById() 등 자동 제공
public interface MemberRepository extends JpaRepository<Member, Long> {
    // 추가 메서드 없음 — JpaRepository 기본 메서드만으로 충분
    // (week7에서 findByName 썼다면 여기서는 id 기반이므로 불필요)
}

