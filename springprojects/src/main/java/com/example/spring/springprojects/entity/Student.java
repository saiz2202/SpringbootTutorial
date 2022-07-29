package com.example.spring.springprojects.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Table(name="student")
@SequenceGenerator(name="studentId",sequenceName ="studentId",initialValue = 1, allocationSize = 50)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "studentId")
    @Column( name="student_id" )

    private Long id;

    @Size(max=100)
    private String firstName;
    @Size(max=100)
    private String lastName;
    @Size(max=250)
    private String fullName;

    @Max(value = 100)
    private int age;

    @ManyToOne
    @JoinColumn(name = "address_ID")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "department_ID")
    private Department department;

}
