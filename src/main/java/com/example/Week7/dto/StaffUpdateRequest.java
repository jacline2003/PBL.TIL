package com.example.Week7.dto;

public class StaffUpdateRequest {
    private String name;
    private String major;
    private Integer generation;
    private String part;
    private String position;

    public String getName() { return name; }
    public String getMajor() { return major; }
    public Integer getGeneration() { return generation; }
    public String getPart() { return part; }
    public String getPosition() { return position; }
}