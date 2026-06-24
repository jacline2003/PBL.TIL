package com.example.Week7.assignment;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findAllByMemberId(Long memberId);
    List<Assignment> findByTitleContaining(String keyword);
}