package com.example.Week7.domain;

public class Staff extends Member {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part, "운영진");
        this.position = position;
    }

    public String getPosition() { return position; }

    public void update(String major, int generation, String part, String position) {
        updateCommonInfo(major, generation, part);
        this.position = position;
    }
}