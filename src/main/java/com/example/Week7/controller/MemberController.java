package com.example.Week7.controller;

import com.example.Week7.dto.*;
import com.example.Week7.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/lions")
    public ResponseEntity<MemberResponse> registerLion(@RequestBody LionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.registerLion(request));
    }

    @PostMapping("/staffs")
    public ResponseEntity<MemberResponse> registerStaff(@RequestBody StaffRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.registerStaff(request));
    }

    @GetMapping("/{name}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable String name) {
        return ResponseEntity.ok(memberService.getMember(name));
    }

    @PutMapping("/lions/{name}")
    public ResponseEntity<MemberResponse> updateLion(@PathVariable String name,
                                                     @RequestBody LionUpdateRequest request) {
        return ResponseEntity.ok(memberService.updateLion(name, request));
    }

    @PutMapping("/staffs/{name}")
    public ResponseEntity<MemberResponse> updateStaff(@PathVariable String name,
                                                      @RequestBody StaffUpdateRequest request) {
        return ResponseEntity.ok(memberService.updateStaff(name, request));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(@PathVariable String name) {
        memberService.deleteMember(name);
        return ResponseEntity.noContent().build();
    }
}