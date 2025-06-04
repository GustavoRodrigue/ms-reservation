package com.school.msreservation.infrastructure.dto;

import com.school.msreservation.domain.enuns.UserEnum;
import lombok.Data;

import java.util.UUID;

@Data
public class UserResponseDto {

    private UUID id;
    private String name;
    private UserEnum type;

}
