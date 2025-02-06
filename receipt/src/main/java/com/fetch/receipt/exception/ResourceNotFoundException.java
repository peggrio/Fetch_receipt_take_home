package com.fetch.receipt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String fieldValue){
        super(String.format("No receipt found for the ID: %s", fieldValue));
    }
}
