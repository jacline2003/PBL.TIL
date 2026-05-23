package com.example.Week7.domain;

public class Lion extends Member {
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part, "아기사자");
        this.studentId = studentId;
    }

    public String getStudentId() { return studentId; }

    public void update(String major, int generation, String part, String studentId) {
        updateCommonInfo(major, generation, part);
        this.studentId = studentId;
    }
}