package com.example.spring.springprojects.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="address")
@SequenceGenerator(name="addressId",sequenceName ="addressId",initialValue = 1, allocationSize = 50)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "addressId")
    @Column( name="address_id" )
    private Long id;
    @Size(max = 50)
    private String doorNo;
    @Size(max = 200)
    private String street;
    private int pincode;


    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "address")
    @JsonIgnore
    private Set<Student> students = new HashSet<>();


}
