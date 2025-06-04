package com.school.msreservation.application.portOut;


import com.school.msreservation.domain.Reservation;
import com.school.msreservation.infrastructure.adapter.adapterOut.CourseAdapterOut;
import com.school.msreservation.infrastructure.adapter.adapterOut.ReservationAdapterOut;
import com.school.msreservation.infrastructure.adapter.adapterOut.UserAdapterOut;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;


@Slf4j
public class ReservationPortOutImpl implements ReservationPortOut {


    final ReservationAdapterOut reservationAdapterOut;
    final CourseAdapterOut courseAdapterOut;
    final UserAdapterOut userAdapterOut;
    final ModelMapper modelMapper;

    public ReservationPortOutImpl(CourseAdapterOut courseAdapterOut, UserAdapterOut userAdapterOut, ModelMapper modelMapper, ReservationAdapterOut reservationAdapterOut) {
        this.courseAdapterOut = courseAdapterOut;
        this.userAdapterOut = userAdapterOut;
        this.modelMapper = modelMapper;
        this.reservationAdapterOut =  reservationAdapterOut;
    }


    public void createReservation(Reservation reservation) {

        reservationAdapterOut.postReservation(reservation);
      log.info("dados postados no kafka", reservation);

    }


}
