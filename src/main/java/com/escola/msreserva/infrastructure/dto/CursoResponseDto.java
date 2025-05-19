package com.escola.msreserva.infrastructure.dto;


import lombok.Data;

import java.util.UUID;

@Data
public class CursoResponseDto {

    private UUID id;

    private String nome;

    private  String descricao;

    private short Capacidade;

}
