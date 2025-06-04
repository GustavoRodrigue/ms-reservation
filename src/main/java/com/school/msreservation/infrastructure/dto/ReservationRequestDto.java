package com.school.msreservation.infrastructure.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ReservationRequestDto {

    private UUID courseId;
    private UUID studentId;
    private UUID teacherId;

}
