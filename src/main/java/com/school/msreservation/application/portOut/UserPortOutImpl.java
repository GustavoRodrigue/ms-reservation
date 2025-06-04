package com.school.msreservation.application.portOut;

import com.school.msreservation.infrastructure.adapter.adapterOut.UserAdapterOut;
import com.school.msreservation.infrastructure.dto.UserResponseDto;

import java.util.UUID;

public class UserPortOutImpl implements UserPortOut {

    final UserAdapterOut userAdapterOut;


    public UserPortOutImpl(UserAdapterOut userAdapterOut) {
        this.userAdapterOut = userAdapterOut;

    }

    @Override
    public UserResponseDto listUserId(UUID id) {
        return userAdapterOut.listUserId(id);

    }
}
