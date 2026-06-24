package com.example.Week7;

import com.example.Week7.exception.AssignmentNotFoundException;
import com.example.Week7.exception.DuplicateMemberNameException;
import com.example.Week7.exception.ErrorResponse;
import com.example.Week7.exception.MemberNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMemberNotFound(MemberNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }

    @ExceptionHandler(AssignmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAssignmentNotFound(AssignmentNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }

    @ExceptionHandler(DuplicateMemberNameException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateName(DuplicateMemberNameException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage()));
    }
}