package com.example.Week7.dto;

import lombok.Getter;

@Getter
public class StaffCreateRequest {
    private String name;
    private String major;
    private Integer generation;
    private String part;
    private String position;
}