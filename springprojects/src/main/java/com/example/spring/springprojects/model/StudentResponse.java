package com.example.spring.springprojects.model;

import com.example.spring.springprojects.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {
    HttpStatus status;
    Student response;
}
