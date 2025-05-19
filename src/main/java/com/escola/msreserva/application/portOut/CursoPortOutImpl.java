package com.escola.msreserva.application.portOut;

import com.escola.msreserva.infrastructure.adapter.adapterOut.CursoAdapterOut;
import com.escola.msreserva.infrastructure.dto.CursoResponseDto;

import java.util.UUID;

public class CursoPortOutImpl implements CursoPortOut{
    final CursoAdapterOut cursoAdapterOut;

    public CursoPortOutImpl(CursoAdapterOut cursoAdapterOut) {
        this.cursoAdapterOut = cursoAdapterOut;
    }

    @Override
    public CursoResponseDto listarCursoId(UUID id) {
        return cursoAdapterOut.listarCursoId(id);
    }
}
