package com.example.Week7.assignment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    // 과제 등록
    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponseDto> create(
            @PathVariable Long memberId,
            @RequestBody AssignmentRequestDto dto) {
        AssignmentResponseDto response = assignmentService.create(memberId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 멤버별 과제 목록 조회
    @GetMapping("/members/{memberId}/assignments")
    public ResponseEntity<List<AssignmentResponseDto>> findAllByMember(
            @PathVariable Long memberId) {
        return ResponseEntity.ok(assignmentService.findAllByMember(memberId));
    }

    // 과제 단건 조회
    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(assignmentService.findById(id));
    }

    // 과제 수정
    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponseDto> update(
            @PathVariable Long id,
            @RequestBody AssignmentRequestDto dto) {
        return ResponseEntity.ok(assignmentService.update(id, dto));
    }

    //과제 삭제
    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        assignmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}