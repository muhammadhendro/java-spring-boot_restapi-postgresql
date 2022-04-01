package com.hendro.alterra.util;

import com.hendro.alterra.model.base.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ResponseUtil {

    private ResponseUtil(){}

    public static ResponseEntity<Object> build(String responseCode, String message, Object data, HttpStatus httpStatus) {
        return new ResponseEntity<>(build(responseCode, message, data), httpStatus);
    }

    private static BaseResponse build(String responseCode, String message, Object data) {
        return BaseResponse.builder()
                .timestamp(LocalDateTime.now())
                .responseCode(responseCode)
                .message(message)
                .data(data)
                .build();
    }
}
