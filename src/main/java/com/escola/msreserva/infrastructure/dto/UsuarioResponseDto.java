package com.escola.msreserva.infrastructure.dto;

import com.escola.msreserva.domain.enuns.UsuarioEnum;
import lombok.Data;

import java.util.UUID;

@Data
public class UsuarioResponseDto {

    private UUID id;
    private String nome;
    private UsuarioEnum tipo;

}
