package com.example.spring.springprojects.service;

import com.example.spring.springprojects.entity.Student;
import com.example.spring.springprojects.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student) {
      return  studentRepository.save(student);
    }
}
