package com.tp.quizAppMicroservices.util;

import com.tp.quizAppMicroservices.Entity.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    private ResponseUtil() {}
    private static ApiResponse initApiResponse() {
        return new ApiResponse();
    }

    public static ResponseEntity<ApiResponse> getBadRequestResponse(Object response) {
        ApiResponse apiResponse = initApiResponse();
        apiResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        apiResponse.setResponse(response);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<ApiResponse> getOkResponse(Object response) {
        ApiResponse apiResponse = initApiResponse();
        apiResponse.setHttpStatus(HttpStatus.OK);
        apiResponse.setStatusCode(HttpStatus.OK.value());
        apiResponse.setResponse(response);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
    }

    public static ResponseEntity<ApiResponse> getNotFoundResponse(Object response){
        ApiResponse apiResponse=initApiResponse();
        apiResponse.setHttpStatus(HttpStatus.NOT_FOUND);
        apiResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        apiResponse.setResponse(response);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }
}
