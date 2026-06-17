package com.example.Week7.controller;

import com.example.Week7.dto.*;

import com.example.Week7.service.MemberService;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/members")

public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {

        this.memberService = memberService;

    }

    // POST /members/lions — 아기사자 등록

    @PostMapping("/lions")

    public ResponseEntity<MemberResponse> createLion(@RequestBody LionCreateRequest request) {

        MemberResponse response = memberService.createLion(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    // POST /members/staffs — 운영진 등록

    @PostMapping("/staffs")

    public ResponseEntity<MemberResponse> createStaff(@RequestBody StaffCreateRequest request) {

        MemberResponse response = memberService.createStaff(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    // GET /members — 전체 조회

    @GetMapping

    public ResponseEntity<List<MemberResponse>> findAll() {

        return ResponseEntity.ok(memberService.findAll());

    }

    // GET /members/{id} — ID로 단일 조회

    @GetMapping("/{id}")

    public ResponseEntity<MemberResponse> findById(@PathVariable Long id) {

        MemberResponse response = memberService.findById(id);

        if (response == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(response);

    }

    // PUT /members/lions/{id} — Lion 수정

    @PutMapping("/lions/{id}")

    public ResponseEntity<MemberResponse> updateLion(@PathVariable Long id,

                                                     @RequestBody LionUpdateRequest request) {

        MemberResponse response = memberService.updateLion(id, request);

        if (response == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(response);

    }

    // PUT /members/staffs/{id} — Staff 수정

    @PutMapping("/staffs/{id}")

    public ResponseEntity<MemberResponse> updateStaff(@PathVariable Long id,

                                                      @RequestBody StaffUpdateRequest request) {

        MemberResponse response = memberService.updateStaff(id, request);

        if (response == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(response);

    }

    // DELETE /members/{id} — 삭제

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {

        boolean deleted = memberService.deleteMember(id);

        if (!deleted) return ResponseEntity.notFound().build();

        return ResponseEntity.noContent().build();  // 204 No Content

    }

}