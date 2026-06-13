package com.example.Week7.dto;

public class LionUpdateRequest {
    private String name;
    private String major;
    private Integer generation;
    private String part;
    private String studentId;

    public LionUpdateRequest() {}

    public String getName() { return name; }
    public String getMajor() { return major; }
    public Integer getGeneration() { return generation; }
    public String getPart() { return part; }
    public String getStudentId() { return studentId; }
}