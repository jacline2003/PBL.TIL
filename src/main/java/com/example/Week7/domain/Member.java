package com.example.Week7.domain;

public abstract class Member {
    private String name;
    private String major;
    private int generation;
    private String part;
    private String roleName;

    protected Member(String name, String major, int generation, String part, String roleName) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.roleName = roleName;
    }

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
    public String getRoleName() { return roleName; }

    protected void updateCommonInfo(String major, int generation, String part) {
        if (major != null) this.major = major;
        if (generation != 0) this.generation = generation;
        if (part != null) this.part = part;
    }
}