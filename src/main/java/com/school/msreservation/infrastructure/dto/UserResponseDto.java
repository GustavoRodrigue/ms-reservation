package com.school.msreservation.infrastructure.dto;

import com.school.msreservation.domain.enuns.UserEnum;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserResponseDto {

    private UUID id;
    private String name;
    private UserEnum type;

}
