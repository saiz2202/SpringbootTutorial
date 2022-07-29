package com.example.spring.springprojects.controller;

import com.example.spring.springprojects.entity.Student;
import com.example.spring.springprojects.model.StudentResponse;
import com.example.spring.springprojects.repository.StudentRepository;
import com.example.spring.springprojects.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @RequestMapping("/student/")
    public ResponseEntity<StudentResponse> saveStudent(@RequestBody Student student) {
        Student studentSaved = studentService.saveStudent(student);
        StudentResponse studentResponse = StudentResponse.builder().response(student).status(HttpStatus.OK).build();
        return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.OK);
    }
}
