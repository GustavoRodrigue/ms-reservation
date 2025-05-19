package com.escola.msreserva.application.portOut;

import com.escola.msreserva.infrastructure.dto.CursoResponseDto;

import java.util.UUID;

public interface CursoPortOut {
    public CursoResponseDto listarCursoId(UUID id);
}
