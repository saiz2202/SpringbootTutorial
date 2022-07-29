package com.example.spring.springprojects.service;

import com.example.spring.springprojects.entity.Department;
import com.example.spring.springprojects.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department saveDepartment(Department department){
       return departmentRepository.save(department);
    }
}
