package com.example.spring.springprojects.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ErrorResponse {

    private HttpStatus httpStatus;
    private String message;
}
