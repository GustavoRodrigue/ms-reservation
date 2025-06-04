package com.school.msreservation.infrastructure.adapter.adapterOut;

import com.school.msreservation.infrastructure.dto.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(url = "http://localhost:8091/user", name = "usuarios-cadastrados")
public interface UserAdapterOut {

    @GetMapping("/{id}")
    public UserResponseDto listUserId(@PathVariable UUID id);
}
