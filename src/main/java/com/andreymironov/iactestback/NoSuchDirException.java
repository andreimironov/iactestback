package com.andreymironov.iactestback;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class NoSuchDirException extends RuntimeException {
    public NoSuchDirException(String message) {
        super(message);
    }
}
