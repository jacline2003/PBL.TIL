package com.example.Week7.domain;

import com.example.Week7.assignment.Assignment;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String major;
    private Integer generation;
    private String part;
    private String position;
    private String studentId;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Assignment> assignments = new ArrayList<>();

    protected Member() {}

    public static Member createLion(String name, String major,
                                    Integer generation, String part,
                                    String studentId) {
        Member member = new Member();
        member.name = name;
        member.major = major;
        member.generation = generation;
        member.part = part;
        member.studentId = studentId;
        member.roleType = RoleType.LION;
        return member;
    }

    public static Member createStaff(String name, String major,
                                     Integer generation, String part,
                                     String position) {
        Member member = new Member();
        member.name = name;
        member.major = major;
        member.generation = generation;
        member.part = part;
        member.position = position;
        member.roleType = RoleType.STAFF;
        return member;
    }

    public void updateLion(String name, String major,
                           Integer generation, String part,
                           String studentId) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
    }

    public void updateStaff(String name, String major,
                            Integer generation, String part,
                            String position) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.position = position;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getMajor() { return major; }
    public Integer getGeneration() { return generation; }
    public String getPart() { return part; }
    public String getPosition() { return position; }
    public String getStudentId() { return studentId; }
    public RoleType getRoleType() { return roleType; }
}