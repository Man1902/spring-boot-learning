package com.learning.rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

    @AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErrorResponse {
    private String errorMessage;
    private HttpStatus status;
    private int statusCode;
    private Date timestamp;
}
