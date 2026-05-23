package com.example.Week7.dto;

import com.example.Week7.domain.Lion;
import com.example.Week7.domain.Member;
import com.example.Week7.domain.Staff;

public class MemberResponse {
    private String name;
    private String major;
    private int generation;
    private String part;
    private String roleName;
    private String studentId;
    private String position;

    public MemberResponse(Member member) {
        this.name = member.getName();
        this.major = member.getMajor();
        this.generation = member.getGeneration();
        this.part = member.getPart();
        this.roleName = member.getRoleName();

        if (member instanceof Lion lion) {
            this.studentId = lion.getStudentId();
        }
        if (member instanceof Staff staff) {
            this.position = staff.getPosition();
        }
    }

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
    public String getRoleName() { return roleName; }
    public String getStudentId() { return studentId; }
    public String getPosition() { return position; }
}