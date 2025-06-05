package com.school.msreservation.infrastructure.adapter.adapterIn;

import com.school.msreservation.application.portIn.ReservationPortIn;
import com.school.msreservation.infrastructure.dto.ReservationRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ReservationControllerTest {

    @InjectMocks
    ReservationController reservationController;

    @Mock
    ReservationPortIn reservationPortIn;

    ReservationRequestDto reservationRequestDto;

    @BeforeEach
    void setUp(){
        reservationController = new ReservationController(reservationPortIn);
        reservationRequestDto = ReservationRequestDto.builder()
                .courseId(UUID.randomUUID())
                .studentId(UUID.randomUUID())
                .teacherId(UUID.randomUUID()).build();

    }

    @Test
    void createReservation() {
        reservationController.createReservation(reservationRequestDto);
        verify(reservationPortIn, times(1)).createReservation(reservationRequestDto);
    }
}