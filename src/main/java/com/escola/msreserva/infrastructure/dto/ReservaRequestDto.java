package com.escola.msreserva.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class ReservaRequestDto {

    private UUID cursoId;
    private UUID alunoId;
    private UUID professorId;

}
