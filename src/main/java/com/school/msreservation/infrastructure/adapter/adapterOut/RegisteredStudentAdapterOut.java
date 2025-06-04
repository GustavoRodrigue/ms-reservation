package com.school.msreservation.infrastructure.adapter.adapterOut;

import com.school.msreservation.infrastructure.dto.RegisteredStudentResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(url = "http://localhost:8081/matriculation", name = "matriculas-cadastrada")
public interface RegisteredStudentAdapterOut {

    @GetMapping("/student")
    public RegisteredStudentResponseDto registeredStudent (@RequestParam UUID idStudent, @RequestParam UUID idCourse);
}
