package com.example.Week7.dto;

import com.example.Week7.domain.Member;
import com.example.Week7.domain.RoleType;

public class MemberResponse {
    private Long id;
    private String name;
    private String major;
    private Integer generation;
    private String part;
    private String roleName;
    private String studentId;
    private String position;

    public static MemberResponse from(Member member) {
        MemberResponse response = new MemberResponse();
        response.id = member.getId();
        response.name = member.getName();
        response.major = member.getMajor();
        response.generation = member.getGeneration();
        response.part = member.getPart();
        response.studentId = member.getStudentId();
        response.position = member.getPosition();
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