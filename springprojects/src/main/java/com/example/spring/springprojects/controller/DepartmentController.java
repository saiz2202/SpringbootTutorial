package com.example.spring.springprojects.controller;

import com.example.spring.springprojects.entity.Department;
import com.example.spring.springprojects.entity.Student;
import com.example.spring.springprojects.model.DepartmentResponse;
import com.example.spring.springprojects.model.StudentResponse;
import com.example.spring.springprojects.service.DepartmentService;
import com.example.spring.springprojects.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }

    @PostMapping("/department/")
    public ResponseEntity<DepartmentResponse> saveStudent(@RequestBody Department department) {
        Department departmentSaved = departmentService.saveDepartment(department);
        DepartmentResponse departmentResponse = DepartmentResponse.builder().response(departmentSaved).status(HttpStatus.OK).build();
        return new ResponseEntity<DepartmentResponse>(departmentResponse,HttpStatus.OK);
    }
}
