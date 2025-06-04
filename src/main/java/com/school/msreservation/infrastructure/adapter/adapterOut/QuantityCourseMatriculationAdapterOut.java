package com.school.msreservation.infrastructure.adapter.adapterOut;

import com.school.msreservation.infrastructure.dto.QuantityCourseMatriculationResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(url = "http://localhost:8081/matriculation", name = "matriculas-cadastradas")
public interface QuantityCourseMatriculationAdapterOut {

    @GetMapping("/{idCourse}")
    public QuantityCourseMatriculationResponseDto quantityCourse(@PathVariable UUID idCourse);



}
