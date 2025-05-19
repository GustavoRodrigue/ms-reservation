package com.escola.msreserva.domain;

import java.util.UUID;

public class Curso {
    private UUID id;
    private String nome;
    private String descricao;
    private short Capacidade;

    public Curso() {

    }

    public Curso(short capacidade, String descricao, String nome, UUID id) {
        Capacidade = capacidade;
        this.descricao = descricao;
        this.nome = nome;
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public short getCapacidade() {
        return Capacidade;
    }

    public void setCapacidade(short capacidade) {
        Capacidade = capacidade;
    }
}
