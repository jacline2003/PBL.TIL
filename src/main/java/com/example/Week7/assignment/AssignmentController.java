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

    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponseDto> create(
            @PathVariable Long memberId, @RequestBody AssignmentRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(assignmentService.create(memberId, dto));
    }

    @GetMapping("/assignments")
    public ResponseEntity<List<AssignmentResponseDto>> findAll() {
        return ResponseEntity.ok(assignmentService.findAll());
    }

    @GetMapping("/members/{memberId}/assignments")
    public ResponseEntity<List<AssignmentResponseDto>> findByMemberId(@PathVariable Long memberId) {
        return ResponseEntity.ok(assignmentService.findAllByMember(memberId));
    }

    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(assignmentService.findById(id));
    }

    @GetMapping("/assignments/search")
    public ResponseEntity<List<AssignmentResponseDto>> searchByTitle(@RequestParam String keyword) {
        return ResponseEntity.ok(assignmentService.searchByTitle(keyword));
    }

    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponseDto> update(
            @PathVariable Long id, @RequestBody AssignmentRequestDto dto) {
        return ResponseEntity.ok(assignmentService.update(id, dto));
    }

    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        assignmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}