package com.example.demo.exceptions;


import com.example.demo.dto.ErrorDTO;
import com.example.demo.exceptions.customexceptions.ResourceNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ErrorDTO> handleResourceNotFoundException(ResourceNotFoundException ex){
        ErrorDTO error = new ErrorDTO(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, error.getCode());
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<ErrorDTO> handleBadRequestException(BadRequestException ex){
        ErrorDTO error = new ErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, error.getCode());
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorDTO> handleAllException(BadRequestException ex){
        ErrorDTO error = new ErrorDTO(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(error, error.getCode());
    }
}
