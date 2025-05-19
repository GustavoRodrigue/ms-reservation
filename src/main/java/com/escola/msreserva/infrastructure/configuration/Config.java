package com.escola.msreserva.infrastructure.configuration;

import com.escola.msreserva.application.portIn.ReservaPortInImpl;
import com.escola.msreserva.application.portOut.*;
import com.escola.msreserva.infrastructure.adapter.adapterOut.CursoAdapterOut;
import com.escola.msreserva.infrastructure.adapter.adapterOut.ReservaAdapterOut;
import com.escola.msreserva.infrastructure.adapter.adapterOut.ReservaAdapterOutImpl;
import com.escola.msreserva.infrastructure.adapter.adapterOut.UsuarioAdapterOut;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class Config {

    @Bean
    public ReservaPortInImpl reservaPortIn(ReservaPortOut reservaPortOut, ModelMapper modelMapper , UsuarioPortOut usuarioPortOut, CursoPortOut cursoPortOut){
        return new ReservaPortInImpl(reservaPortOut, modelMapper, usuarioPortOut, cursoPortOut);
    }

    @Bean
    public ReservaPortOutImpl reservaPortOut(CursoAdapterOut cursoAdapterOut, UsuarioAdapterOut usuarioAdapterOut, ModelMapper modelMapper, ReservaAdapterOut reservaAdapterOut){
        return new ReservaPortOutImpl(cursoAdapterOut, usuarioAdapterOut, modelMapper, reservaAdapterOut);
    }

    @Bean
    public ReservaAdapterOutImpl reservaAdapterOut(KafkaTemplate kafkaTemplate){
        return new ReservaAdapterOutImpl( kafkaTemplate);
    }

    @Bean
    public UsuarioPortOutImpl usuarioPortOut(UsuarioAdapterOut usuarioAdapterOut) {
        return new UsuarioPortOutImpl(usuarioAdapterOut);

    }

    @Bean
    public CursoPortOutImpl cursoPortOut(CursoAdapterOut cursoAdapterOut) {
        return new CursoPortOutImpl(cursoAdapterOut);
    }

    @Bean
    public  ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
