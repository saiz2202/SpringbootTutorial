package com.example.spring.springprojects.event;

import com.example.spring.springprojects.entity.Address;
import com.example.spring.springprojects.entity.Department;
import com.example.spring.springprojects.repository.AddressRepository;
import com.example.spring.springprojects.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sun.tools.jar.CommandLine;

@Component
public class ApplicationDataInsertStartUp implements CommandLineRunner {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void run(String... args) throws Exception {

        // Create department and address sample data
        Department department= Department.builder().departmentCode("001").departmentHead("RAM").departmentName("IT").build();
        Address address = Address.builder().doorNo("222").pincode(212121).street("2nd sreet").build();

        addressRepository.save(address);
        departmentRepository.save(department);


    }
}
