package com.learning.rest.service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserNotFoundException extends Exception {
    private String errorMessage;
    private HttpStatus statusCode = HttpStatus.NOT_FOUND;

    public UserNotFoundException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
