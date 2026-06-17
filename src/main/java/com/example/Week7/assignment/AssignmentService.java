package com.example.Week7.assignment;


import com.example.Week7.domain.Member;
import com.example.Week7.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional  // 클래스 전체에 트랜잭션 적용 (쓰기 작업 기본)
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    // 과제 등록
    public AssignmentResponseDto create(Long memberId, AssignmentRequestDto dto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 멤버입니다."));

        Assignment assignment = new Assignment(dto.getTitle(), dto.getDescription(), member);
        assignmentRepository.save(assignment);
        return new AssignmentResponseDto(assignment);
    }

    // 멤버별 과제 목록 조회
    @Transactional(readOnly = true)  // 조회 전용: 변경 감지 비활성화 → 성능 최적화
    public List<AssignmentResponseDto> findAllByMember(Long memberId) {
        memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 멤버입니다."));

        return assignmentRepository.findAllByMemberId(memberId)
                .stream()
                .map(AssignmentResponseDto::new)
                .collect(Collectors.toList());
    }

    // 과제 단건 조회
    @Transactional(readOnly = true)
    public AssignmentResponseDto findById(Long id) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 과제입니다."));
        return new AssignmentResponseDto(assignment);
    }

    // 과제 수정
    public AssignmentResponseDto update(Long id, AssignmentRequestDto dto) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 과제입니다."));
        assignment.update(dto.getTitle(), dto.getDescription());
        return new AssignmentResponseDto(assignment);
    }

    // 과제 삭제
    public void delete(Long id) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 과제입니다."));
        assignmentRepository.delete(assignment);
    }
}