package com.project.appproduct.exception;

import com.project.appproduct.controller.ErrorMessage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
public class ResponseMessageException extends RuntimeException {

    private final String code;
    private final String message;
    private final List<ErrorMessage> errorMessages;
    private final HttpStatus httpStatus;

    public ResponseMessageException(String code, String message, List<ErrorMessage> errorMessages, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.errorMessages = errorMessages;
        this.httpStatus = httpStatus;
    }
}
