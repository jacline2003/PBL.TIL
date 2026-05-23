package com.example.Week7.service;

import com.example.Week7.domain.Lion;
import com.example.Week7.domain.Member;
import com.example.Week7.domain.Staff;
import com.example.Week7.dto.*;
        import com.example.Week7.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberResponse registerLion(LionRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        }
        Lion lion = new Lion(request.getName(), request.getMajor(),
                request.getGeneration(), request.getPart(), request.getStudentId());
        memberRepository.save(lion);
        return new MemberResponse(lion);
    }

    public MemberResponse registerStaff(StaffRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        }
        Staff staff = new Staff(request.getName(), request.getMajor(),
                request.getGeneration(), request.getPart(), request.getPosition());
        memberRepository.save(staff);
        return new MemberResponse(staff);
    }

    public MemberResponse getMember(String name) {
        Member member = memberRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 멤버입니다."));
        return new MemberResponse(member);
    }

    public MemberResponse updateLion(String name, LionUpdateRequest request) {
        Member member = memberRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 멤버입니다."));
        if (!(member instanceof Lion lion)) {
            throw new IllegalArgumentException("아기사자 멤버가 아닙니다.");
        }
        lion.update(request.getMajor(), request.getGeneration(),
                request.getPart(), request.getStudentId());
        return new MemberResponse(lion);
    }

    public MemberResponse updateStaff(String name, StaffUpdateRequest request) {
        Member member = memberRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 멤버입니다."));
        if (!(member instanceof Staff staff)) {
            throw new IllegalArgumentException("운영진 멤버가 아닙니다.");
        }
        staff.update(request.getMajor(), request.getGeneration(),
                request.getPart(), request.getPosition());
        return new MemberResponse(staff);
    }

    public void deleteMember(String name) {
        if (!memberRepository.existsByName(name)) {
            throw new IllegalArgumentException("존재하지 않는 멤버입니다.");
        }
        memberRepository.deleteByName(name);
    }
}