package com.school.msreservation.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDto {

    private UUID courseId;
    private UUID studentId;
    private UUID teacherId;

}
