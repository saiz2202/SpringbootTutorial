package com.example.spring.springprojects.repository;

import com.example.spring.springprojects.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface StudentRepository extends JpaRepository<Student, Id> {
}
