package com.mavericsystems.digitalinterviewportal.services.exception;

import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException{
    private Integer statusCode;
    private String message;

    public CommonException(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
