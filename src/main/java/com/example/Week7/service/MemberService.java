package com.example.Week7.service;

import com.example.Week7.domain.Member;
import com.example.Week7.dto.*;
import com.example.Week7.exception.DuplicateMemberNameException;
import com.example.Week7.exception.MemberNotFoundException;
import com.example.Week7.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberResponse createLion(LionCreateRequest request) {
        if (memberRepository.findByName(request.getName()).isPresent()) {
            throw new DuplicateMemberNameException(request.getName());
        }
        Member saved = memberRepository.save(Member.createLion(
                request.getName(), request.getMajor(),
                request.getGeneration(), request.getPart(), request.getStudentId()));
        return MemberResponse.from(saved);
    }

    @Transactional
    public MemberResponse createStaff(StaffCreateRequest request) {
        if (memberRepository.findByName(request.getName()).isPresent()) {
            throw new DuplicateMemberNameException(request.getName());
        }
        Member saved = memberRepository.save(Member.createStaff(
                request.getName(), request.getMajor(),
                request.getGeneration(), request.getPart(), request.getPosition()));
        return MemberResponse.from(saved);
    }

    @Transactional(readOnly = true)
    public List<MemberResponse> findAll(String part) {
        List<Member> members = (part != null)
                ? memberRepository.findByPart(part)
                : memberRepository.findAll();
        return members.stream().map(MemberResponse::from).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MemberResponse findById(Long id) {
        return MemberResponse.from(memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(id)));
    }

    @Transactional
    public MemberResponse updateLion(Long id, LionUpdateRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(id));
        member.updateLion(request.getName(), request.getMajor(),
                request.getGeneration(), request.getPart(), request.getStudentId());
        return MemberResponse.from(member);
    }

    @Transactional
    public MemberResponse updateStaff(Long id, StaffUpdateRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(id));
        member.updateStaff(request.getName(), request.getMajor(),
                request.getGeneration(), request.getPart(), request.getPosition());
        return MemberResponse.from(member);
    }

    @Transactional
    public void deleteMember(Long id) {
        memberRepository.delete(memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(id)));
    }
}