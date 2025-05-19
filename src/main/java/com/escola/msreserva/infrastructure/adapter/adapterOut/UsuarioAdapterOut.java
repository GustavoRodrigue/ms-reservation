package com.escola.msreserva.infrastructure.adapter.adapterOut;

import com.escola.msreserva.infrastructure.dto.UsuarioResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(url = "http://localhost:8091/usuario", name = "usuarios-cadastrados")
public interface UsuarioAdapterOut {

    @GetMapping("/{id}")
    public UsuarioResponseDto listarUsuarioId(@PathVariable UUID id);
}
