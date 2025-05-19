package com.escola.msreserva.application.portOut;


import com.escola.msreserva.infrastructure.dto.UsuarioResponseDto;


import java.util.UUID;

public interface UsuarioPortOut {
    public UsuarioResponseDto listarUsuarioId(UUID id);

}
