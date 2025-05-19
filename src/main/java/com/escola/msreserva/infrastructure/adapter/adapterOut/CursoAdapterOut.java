package com.escola.msreserva.infrastructure.adapter.adapterOut;

import com.escola.msreserva.infrastructure.dto.CursoResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.UUID;

@FeignClient(url = "http://localhost:8080/curso", name = "cursos-cadastrados")
public interface CursoAdapterOut {

     @GetMapping("/{id}")
    public CursoResponseDto listarCursoId(@PathVariable UUID id);




}
