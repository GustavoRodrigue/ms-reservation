package com.school.msreservation.domain;

import java.util.UUID;

public class Course {
    private UUID id;
    private String name;
    private  String description;
    private int capacity;

    public Course() {

    }

    public Course(UUID id, String name, String description, int capacity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
