package com.project.appcustomer.controller;

import com.project.appcustomer.exception.ResponseMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ResponseControlMessage> runtimeExceptionHandler(RuntimeException ex) {
        ResponseControlMessage error = ResponseControlMessage.builder().code("500").message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ResponseMessageException.class)
    public ResponseEntity<ResponseControlMessage> responseStatusExceptionHandler(ResponseMessageException ex) {
        ResponseControlMessage error = ResponseControlMessage.builder().code(ex.getCode()).message(ex.getMessage()).errorMessages(ex.getErrorMessages()).build();
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }
}
