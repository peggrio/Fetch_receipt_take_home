package com.fetch.receipt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class JsonParseException extends RuntimeException{
    public JsonParseException(String message) {
        super(message);
    }
}
