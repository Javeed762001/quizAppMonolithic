package com.tp.quizAppMicroservices.Entity;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponse {

    private int statusCode;
    private HttpStatus httpStatus;
    private Object response;
}
