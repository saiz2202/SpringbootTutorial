package com.example.spring.springprojects.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="department")
@SequenceGenerator(name="departmentId",sequenceName ="departmentId",initialValue = 1, allocationSize = 50)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "departmentId")
    @Column( name="department_id" )
    private Long id;
    @Size(max = 10)
    private String departmentCode;
    private String departmentName;
    private String departmentHead;


    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "department")
    @JsonIgnore
    private Set<Student> students = new HashSet<>();

}