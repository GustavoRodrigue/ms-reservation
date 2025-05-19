package com.escola.msreserva.domain;

import com.escola.msreserva.domain.enuns.UsuarioEnum;

import java.util.UUID;

public class Usuario {
    private UUID id;
    private String nome;
    private UsuarioEnum tipo;

    public Usuario() {
    }

    public Usuario(UUID id, String nome, UsuarioEnum tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
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

    public UsuarioEnum getTipo() {
        return tipo;
    }

    public void setTipo(UsuarioEnum tipo) {
        this.tipo = tipo;
    }
}
