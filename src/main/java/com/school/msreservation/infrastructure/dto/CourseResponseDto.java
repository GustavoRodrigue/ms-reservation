package com.school.msreservation.infrastructure.dto;


import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CourseResponseDto {

    private UUID id;
    private String name;
    private  String description;
    private int capacity;

}
