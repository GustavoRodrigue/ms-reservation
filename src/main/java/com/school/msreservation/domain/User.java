package com.school.msreservation.domain;

import com.school.msreservation.domain.enuns.UserEnum;

import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private UserEnum type;

    public User() {
    }

    public User(UUID id, String name, UserEnum type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEnum getType() {
        return type;
    }

    public void setType(UserEnum type) {
        this.type = type;
    }
}
