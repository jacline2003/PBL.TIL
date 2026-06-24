package com.example.Week7.exception;

public class DuplicateMemberNameException extends RuntimeException {
    public DuplicateMemberNameException(String name) {
        super("이미 존재하는 이름입니다. name: " + name);
    }
}