package com.school.msreservation.application.portOut;


import com.school.msreservation.infrastructure.dto.UserResponseDto;


import java.util.UUID;

public interface UserPortOut {
    public UserResponseDto listUserId(UUID id);

}
