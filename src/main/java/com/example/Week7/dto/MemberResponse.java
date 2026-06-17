package com.example.Week7.dto;

import com.example.Week7.domain.Member;
import com.example.Week7.domain.RoleType;

public class MemberResponse {
    private Long id;
    private String name;
    private String major;
    private Integer generation;
    private String part;
    private String roleName;   // "아기사자" or "운영진" (한국어로 변환해서 반환)
    private String studentId;
    private String position;

    // Member 엔티티 → Response DTO 변환
    public static MemberResponse from(Member member) {
        MemberResponse response = new MemberResponse();
        response.id = member.getId();
        response.name = member.getName();
        response.major = member.getMajor();
        response.generation = member.getGeneration();
        response.part = member.getPart();
        response.studentId = member.getStudentId();
        response.position = member.getPosition();

        // RoleType enum → 한국어 이름 변환
        response.roleName = member.getRoleType() == RoleType.LION ? "아기사자" : "운영진";

        return response;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getMajor() { return major; }
    public Integer getGeneration() { return generation; }
    public String getPart() { return part; }
    public String getRoleName() { return roleName; }
    public String getStudentId() { return studentId; }
    public String getPosition() { return position; }
}