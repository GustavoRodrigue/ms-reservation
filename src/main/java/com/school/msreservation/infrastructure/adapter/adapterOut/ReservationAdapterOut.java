package com.school.msreservation.infrastructure.adapter.adapterOut;

import com.school.msreservation.domain.Reservation;

public interface ReservationAdapterOut {

    void postReservation(Reservation reservation);
}
