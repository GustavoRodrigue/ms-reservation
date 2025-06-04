package com.school.msreservation.infrastructure.adapter.adapterOut;

import com.school.msreservation.infrastructure.dto.CourseResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.UUID;

@FeignClient(url = "http://localhost:8080/course", name = "cursos-cadastrados")
public interface CourseAdapterOut {

     @GetMapping("/{id}")
    public CourseResponseDto listCourseId(@PathVariable UUID id);




}
