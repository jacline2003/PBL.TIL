package com.example.Week7.assignment;

import com.example.Week7.domain.Member;
import com.example.Week7.exception.AssignmentNotFoundException;
import com.example.Week7.exception.MemberNotFoundException;
import com.example.Week7.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    public AssignmentResponseDto create(Long memberId, AssignmentRequestDto dto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(memberId));
        return new AssignmentResponseDto(assignmentRepository.save(
                new Assignment(dto.getTitle(), dto.getDescription(), member)));
    }

    @Transactional(readOnly = true)
    public List<AssignmentResponseDto> findAll() {
        return assignmentRepository.findAll().stream()
                .map(AssignmentResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<AssignmentResponseDto> findAllByMember(Long memberId) {
        memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(memberId));
        return assignmentRepository.findAllByMemberId(memberId).stream()
                .map(AssignmentResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AssignmentResponseDto findById(Long id) {
        return new AssignmentResponseDto(assignmentRepository.findById(id)
                .orElseThrow(() -> new AssignmentNotFoundException(id)));
    }

    @Transactional(readOnly = true)
    public List<AssignmentResponseDto> searchByTitle(String keyword) {
        return assignmentRepository.findByTitleContaining(keyword).stream()
                .map(AssignmentResponseDto::new).collect(Collectors.toList());
    }

    public AssignmentResponseDto update(Long id, AssignmentRequestDto dto) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new AssignmentNotFoundException(id));
        assignment.update(dto.getTitle(), dto.getDescription());
        return new AssignmentResponseDto(assignment);
    }

    public void delete(Long id) {
        assignmentRepository.delete(assignmentRepository.findById(id)
                .orElseThrow(() -> new AssignmentNotFoundException(id)));
    }
}