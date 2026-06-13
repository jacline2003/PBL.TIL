package com.example.Week7.service;

import com.example.Week7.domain.Member;

import com.example.Week7.dto.*;

import com.example.Week7.repository.MemberRepository;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.stream.Collectors;

@Service

public class MemberService {

    private final MemberRepository memberRepository;

    // 생성자 주입

    public MemberService(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;

    }

    // Lion 등록

    @Transactional

    public MemberResponse createLion(LionCreateRequest request) {

        Member member = Member.createLion(

                request.getName(),

                request.getMajor(),

                request.getGeneration(),

                request.getPart(),

                request.getStudentId()

        );

        // save() 호출 시 영속성 컨텍스트에 저장 + DB INSERT 실행

        // → INSERT 후 DB가 생성한 id가 member 객체에 자동으로 채워짐 (IDENTITY 전략)

        Member saved = memberRepository.save(member);

        return MemberResponse.from(saved);

    }

    // Staff 등록

    @Transactional

    public MemberResponse createStaff(StaffCreateRequest request) {

        Member member = Member.createStaff(

                request.getName(),

                request.getMajor(),

                request.getGeneration(),

                request.getPart(),

                request.getPosition()

        );

        Member saved = memberRepository.save(member);

        return MemberResponse.from(saved);

    }

    // 전체 조회

    @Transactional(readOnly = true)

    public List<MemberResponse> findAll() {

        return memberRepository.findAll()

                .stream()

                .map(MemberResponse::from)

                .collect(Collectors.toList());

    }

    // ID로 단일 조회

    @Transactional(readOnly = true)

    public MemberResponse findById(Long id) {

        // findById() → Optional 반환 → 없으면 null 반환 (week7 패턴 유지)

        return memberRepository.findById(id)

                .map(MemberResponse::from)

                .orElse(null);

    }

    // Lion 수정

    @Transactional

    public MemberResponse updateLion(Long id, LionUpdateRequest request) {

        Member member = memberRepository.findById(id).orElse(null);

        if (member == null) return null;

        member.updateLion(

                request.getName(),

                request.getMajor(),

                request.getGeneration(),

                request.getPart(),

                request.getStudentId()

        );

        // @Transactional 덕분에 별도 save() 없이도 변경 감지(dirty checking)로 UPDATE 실행

        return MemberResponse.from(member);

    }

    // Staff 수정

    @Transactional

    public MemberResponse updateStaff(Long id, StaffUpdateRequest request) {

        Member member = memberRepository.findById(id).orElse(null);

        if (member == null) return null;

        member.updateStaff(

                request.getName(),

                request.getMajor(),

                request.getGeneration(),

                request.getPart(),

                request.getPosition()

        );

        return MemberResponse.from(member);

    }

    // 삭제

    @Transactional

    public boolean deleteMember(Long id) {

        if (!memberRepository.existsById(id)) return false;

        memberRepository.deleteById(id);

        return true;

    }

}