package com.school.msreservation.application.portOut;

import com.school.msreservation.infrastructure.adapter.adapterOut.CourseAdapterOut;
import com.school.msreservation.infrastructure.dto.CourseResponseDto;

import java.util.UUID;

public class CoursePortOutImpl implements CoursePortOut {
    final CourseAdapterOut courseAdapterOut;

    public CoursePortOutImpl(CourseAdapterOut cursoAdapterOut) {
        this.courseAdapterOut = cursoAdapterOut;
    }

    @Override
    public CourseResponseDto listCourseId(UUID id) {
        return courseAdapterOut.listCourseId(id);
    }
}
