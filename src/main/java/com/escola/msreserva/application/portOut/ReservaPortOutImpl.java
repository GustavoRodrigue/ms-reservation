package com.escola.msreserva.application.portOut;


import com.escola.msreserva.application.portIn.ReservaPortIn;
import com.escola.msreserva.domain.Reserva;
import com.escola.msreserva.infrastructure.adapter.adapterOut.CursoAdapterOut;
import com.escola.msreserva.infrastructure.adapter.adapterOut.ReservaAdapterOut;
import com.escola.msreserva.infrastructure.adapter.adapterOut.UsuarioAdapterOut;
import com.escola.msreserva.infrastructure.dto.ReservaRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;


@Slf4j
public class ReservaPortOutImpl implements ReservaPortOut {


    final ReservaAdapterOut reservaAdapterOut;
    final CursoAdapterOut cursoAdapterOut;
    final UsuarioAdapterOut usuarioAdapterOut;
    final ModelMapper modelMapper;

    public ReservaPortOutImpl(CursoAdapterOut cursoAdapterOut, UsuarioAdapterOut usuarioAdapterOut, ModelMapper modelMapper, ReservaAdapterOut reservaAdapterOut) {
        this.cursoAdapterOut = cursoAdapterOut;
        this.usuarioAdapterOut = usuarioAdapterOut;
        this.modelMapper = modelMapper;
        this.reservaAdapterOut =  reservaAdapterOut;
    }


    public void criarReserva(Reserva reserva) {

        reservaAdapterOut.postarReserva(reserva);
//        kafkaTemplate.send("reserva",reserva);
//        log.info("dados postados no kafka", reserva);

    }


}
