package com.example.spring.springprojects.controller;

import com.example.spring.springprojects.entity.Address;
import com.example.spring.springprojects.entity.Student;
import com.example.spring.springprojects.exception.StudentNotFoundException;
import com.example.spring.springprojects.model.StudentResponse;
import com.example.spring.springprojects.repository.StudentRepository;
import com.example.spring.springprojects.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping ("/student")
    public ResponseEntity<StudentResponse> saveStudent(@RequestBody Student student) {
        Address address = student.getAddress();
        Student studentSaved = studentService.saveStudent(student);
        StudentResponse studentResponse = StudentResponse.builder().response(student).status(HttpStatus.OK).build();
        return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public Student getStudentsBasedOnId(@PathVariable Long id) throws StudentNotFoundException{
       Optional<Student> student= studentService.getStudentsBasedOnId(id);
       if(student.isPresent()){
           return student.get();
       }else{
           throw new StudentNotFoundException("Student id is not present is in the database");
       }
    }
}
