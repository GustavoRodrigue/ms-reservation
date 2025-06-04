package com.school.msreservation.infrastructure.dto;

public class DtoErrorResponse extends RuntimeException {
    public DtoErrorResponse(String message) {
        super(message);
    }
}
