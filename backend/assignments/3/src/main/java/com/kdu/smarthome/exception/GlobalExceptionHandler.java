package com.kdu.smarthome.exception;

import com.kdu.smarthome.dto.ErrorDTO;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value={BadRequestException.class})
    public ResponseEntity<ErrorDTO> badRequestException(BadRequestException ex){
        ErrorDTO errordto = new ErrorDTO(ex.getMessage() + "[Bad Request Exception]", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errordto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorDTO> exceptions(Exception ex){
        ErrorDTO errordto = new ErrorDTO(ex.getMessage() + " [Parent Exception]", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errordto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {MyCustomException.class})
    public ResponseEntity<ErrorDTO> myCustomexceptions(MyCustomException ex){
        ErrorDTO errordto = new ErrorDTO(ex.getMessage() + " [Custom Exception]", HttpStatus.UNAUTHORIZED.value());
        return new ResponseEntity<>(errordto, HttpStatus.UNAUTHORIZED);
    }
}