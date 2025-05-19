package com.escola.msreserva.domain;

import java.util.UUID;

public class Reserva {
    private UUID cursoId;
    private String cursoNome;
    private UUID alunoId;
    private String alunoNome;
    private UUID professorId;
    private String professorNome;

    public Reserva() {
    }

    public Reserva(UUID cursoId, String cursoNome, UUID alunoId, String alunoNome, UUID professorId, String professorNome) {
        this.cursoId = cursoId;
        this.cursoNome = cursoNome;
        this.alunoId = alunoId;
        this.alunoNome = alunoNome;
        this.professorId = professorId;
        this.professorNome = professorNome;
    }

    public UUID getCursoId() {
        return cursoId;
    }

    public void setCursoId(UUID cursoId) {
        this.cursoId = cursoId;
    }

    public String getCursoNome() {
        return cursoNome;
    }

    public void setCursoNome(String cursoNome) {
        this.cursoNome = cursoNome;
    }

    public UUID getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(UUID alunoId) {
        this.alunoId = alunoId;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public UUID getProfessorId() {
        return professorId;
    }

    public void setProfessorId(UUID professorId) {
        this.professorId = professorId;
    }

    public String getProfessorNome() {
        return professorNome;
    }

    public void setProfessorNome(String professorNome) {
        this.professorNome = professorNome;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cursoId=" + cursoId +
                ", cursoNome='" + cursoNome + '\'' +
                ", alunoId=" + alunoId +
                ", alunoNome='" + alunoNome + '\'' +
                ", professorId=" + professorId +
                ", professorNome='" + professorNome + '\'' +
                '}';
    }
}


