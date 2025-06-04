package com.school.msreservation.infrastructure.dto;


import lombok.Data;

import java.util.UUID;

@Data
public class CourseResponseDto {

    private UUID id;
    private String name;
    private  String description;
    private int capacity;

}
