package com.example.Week7.assignment;

import lombok.Getter;

@Getter
public class AssignmentResponseDto {
    private Long id;
    private String title;
    private String description;
    private Long memberId;
    private String memberName;

    public AssignmentResponseDto(Assignment assignment) {
        this.id = assignment.getId();
        this.title = assignment.getTitle();
        this.description = assignment.getDescription();
        this.memberId = assignment.getMember().getId();
        this.memberName = assignment.getMember().getName();
    }
}
