package com.andreymironov.iactestback;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
public class UnknownIOException extends RuntimeException {
    public UnknownIOException(String message) {
        super(message);
    }
}
