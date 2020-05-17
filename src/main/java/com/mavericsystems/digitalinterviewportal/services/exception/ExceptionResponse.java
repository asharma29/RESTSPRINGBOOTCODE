package com.mavericsystems.digitalinterviewportal.services.exception;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
    private Integer code;
    private String message;

    public ExceptionResponse(Integer code,  String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
