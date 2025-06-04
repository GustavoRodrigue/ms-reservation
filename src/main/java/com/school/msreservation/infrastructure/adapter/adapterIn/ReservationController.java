package com.school.msreservation.infrastructure.adapter.adapterIn;

import com.school.msreservation.application.portIn.ReservationPortIn;
import com.school.msreservation.infrastructure.dto.ReservationRequestDto;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/reservation")
public class ReservationController {

    final ReservationPortIn reservaPortIn;

    public ReservationController(ReservationPortIn reservaPortIn) {
        this.reservaPortIn = reservaPortIn;
    }

    @PostMapping()
    public void createReservation(@RequestBody ReservationRequestDto reservaRequestDto){

        reservaPortIn.createReservation(reservaRequestDto);
    }

}
