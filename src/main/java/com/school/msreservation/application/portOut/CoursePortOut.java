package com.school.msreservation.application.portOut;

import com.school.msreservation.infrastructure.dto.CourseResponseDto;

import java.util.UUID;

public interface CoursePortOut {
    public CourseResponseDto listCourseId(UUID id);
}
