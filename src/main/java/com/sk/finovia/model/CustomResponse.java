package com.sk.finovia.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class CustomResponse {

    private boolean success;
    private String message;
    private Customer data;

    private HttpStatus statusCode;

    public CustomResponse(boolean success, String message, Customer data, HttpStatus statusCode) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.statusCode = statusCode;

    }
}
