package com.escola.msreserva.infrastructure.adapter.adapterIn;

import com.escola.msreserva.application.portIn.ReservaPortIn;
import com.escola.msreserva.infrastructure.dto.ReservaRequestDto;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/reserva")
public class ReservaController {

    final ReservaPortIn reservaPortIn;

    public ReservaController(ReservaPortIn reservaPortIn) {
        this.reservaPortIn = reservaPortIn;
    }

    @PostMapping()
    public void criarReseva(@RequestBody ReservaRequestDto reservaRequestDto){

        reservaPortIn.criarReserva(reservaRequestDto);
    }
//
//    @GetMapping("/usuario")
//    public List<UsuarioResponseDto> listarTodosUsuarios(){
//        return reservaPortIn.listartodosUsuario();
//    }
}
