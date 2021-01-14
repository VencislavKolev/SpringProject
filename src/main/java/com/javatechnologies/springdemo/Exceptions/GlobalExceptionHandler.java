package com.javatechnologies.springdemo.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("NOT_FOUND");
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExists.class)
    public ResponseEntity<ExceptionResponse> resourceAlreadyExists(ResourceAlreadyExists ex) {
        ExceptionResponse response=new ExceptionResponse();
        response.setErrorCode("CONFLICT");
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<ExceptionResponse> invalidArgument(InvalidArgumentException ex) {
        ExceptionResponse response=new ExceptionResponse();
        response.setErrorCode("INVALID ARGUMENT");
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> illegalArgumentException(IllegalArgumentException ex) {
        ExceptionResponse response=new ExceptionResponse();
        response.setErrorCode("INVALID ARGUMENT");
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ExceptionResponse> unauthorizedException(UnauthorizedException ex) {
        ExceptionResponse response=new ExceptionResponse();
        response.setErrorCode("UNAUTHORIZED");
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

}