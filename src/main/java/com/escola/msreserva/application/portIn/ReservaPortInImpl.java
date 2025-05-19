package com.escola.msreserva.application.portIn;

import com.escola.msreserva.application.portOut.CursoPortOut;
import com.escola.msreserva.application.portOut.ReservaPortOut;
import com.escola.msreserva.application.portOut.UsuarioPortOut;
import com.escola.msreserva.domain.Curso;
import com.escola.msreserva.domain.Reserva;
import com.escola.msreserva.domain.Usuario;
import com.escola.msreserva.domain.enuns.UsuarioEnum;
import com.escola.msreserva.infrastructure.adapter.adapterOut.CursoAdapterOut;

import com.escola.msreserva.infrastructure.dto.CursoResponseDto;
import com.escola.msreserva.infrastructure.dto.ReservaRequestDto;
import com.escola.msreserva.infrastructure.dto.UsuarioResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;


public class ReservaPortInImpl implements ReservaPortIn {
    final ReservaPortOut reservaPortOut;
    private ModelMapper modelMapper;
    final UsuarioPortOut usuarioPortOut;
    final CursoPortOut cursoPortOut;



    public ReservaPortInImpl(ReservaPortOut reservaPortOut, ModelMapper modelMapper, UsuarioPortOut usuarioPortOut,  CursoPortOut cursoPortOut) {
        this.reservaPortOut = reservaPortOut;
        this.modelMapper = modelMapper;
        this.usuarioPortOut = usuarioPortOut;
        this.cursoPortOut = cursoPortOut;

    }

    @Override
    public void criarReserva(ReservaRequestDto reservaRequestDto) {


        CursoResponseDto cursoResponseDto = cursoPortOut.listarCursoId(reservaRequestDto.getCursoId());
        Curso curso = modelMapper.map(cursoResponseDto, Curso.class);


        UsuarioResponseDto alunoDto = usuarioPortOut.listarUsuarioId(reservaRequestDto.getAlunoId());
        Usuario aluno = modelMapper.map(alunoDto, Usuario.class);

        UsuarioResponseDto professorDto = usuarioPortOut.listarUsuarioId(reservaRequestDto.getProfessorId());
        Usuario professor = modelMapper.map(professorDto, Usuario.class);

        if (aluno.getTipo().equals(UsuarioEnum.ALUNO) && professor.getTipo().equals(UsuarioEnum.PROFESSOR)){
            Reserva reserva = new Reserva();
            reserva.setAlunoId(aluno.getId());
            reserva.setAlunoNome(aluno.getNome());
            reserva.setCursoId(curso.getId());
            reserva.setCursoNome(curso.getNome());
            reserva.setProfessorId(curso.getId());
            reserva.setProfessorNome(curso.getNome());

            reservaPortOut.criarReserva(reserva);


        }




    }




}
