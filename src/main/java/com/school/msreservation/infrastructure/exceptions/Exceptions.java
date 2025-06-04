package com.school.msreservation.infrastructure.exceptions;

import com.school.msreservation.infrastructure.dto.DtoError;
import com.school.msreservation.infrastructure.dto.DtoErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class Exceptions {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<DtoError> bedRequest(HttpMessageNotReadableException ex){
        DtoError error = new DtoError();
        error.setStatus("Ocorreu um erro de Status 400");
        error.setDetail("Dados invalidos");
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler(NoResourceFoundException.class)
    public  ResponseEntity<DtoError> notFound(NoResourceFoundException ex){
        DtoError error = new DtoError();
        error.setStatus("Ocorreu um erro de Status 404");
        error.setDetail("Verifique a exixstencia do endereço solicitado");
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler (DtoErrorResponse.class)
    public ResponseEntity<DtoError> serverError(){
        DtoError error = new DtoError();
        error.setStatus("Ocorreu um erro de status '500'");
        error.setDetail("Erro ao acessar no banco de dados");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }


}
