package com.escola.msreserva.application.portOut;

import com.escola.msreserva.domain.Reserva;
import com.escola.msreserva.infrastructure.adapter.adapterOut.CursoAdapterOut;
import com.escola.msreserva.infrastructure.adapter.adapterOut.UsuarioAdapterOut;
import com.escola.msreserva.infrastructure.dto.CursoResponseDto;
import com.escola.msreserva.infrastructure.dto.ReservaRequestDto;
import com.escola.msreserva.infrastructure.dto.UsuarioResponseDto;

import java.util.UUID;

public class UsuarioPortOutImpl implements UsuarioPortOut {

    final UsuarioAdapterOut usuarioAdapterOut;


    public UsuarioPortOutImpl(UsuarioAdapterOut usuarioAdapterOut) {
        this.usuarioAdapterOut = usuarioAdapterOut;

    }

    @Override
    public UsuarioResponseDto listarUsuarioId(UUID id) {
        return usuarioAdapterOut.listarUsuarioId(id);

    }
}
