package com.school.msreservation.application.portIn;



import com.school.msreservation.infrastructure.dto.ReservationRequestDto;


public interface ReservationPortIn {
    void createReservation(ReservationRequestDto reservationRequestDto);


}
