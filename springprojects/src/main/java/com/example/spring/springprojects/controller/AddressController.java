package com.example.spring.springprojects.controller;

import com.example.spring.springprojects.entity.Address;
import com.example.spring.springprojects.entity.Student;
import com.example.spring.springprojects.model.AddressResponse;
import com.example.spring.springprojects.model.StudentResponse;
import com.example.spring.springprojects.service.AddressService;
import com.example.spring.springprojects.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AddressController {
    private AddressService addressService;

    public AddressController(AddressService addressService){
        this.addressService=addressService;
    }

    @PostMapping("/address/")
    public ResponseEntity<AddressResponse> saveAddress(@RequestBody Address address) {
        Address addressSaved = addressService.saveAddress(address);
        AddressResponse addressResponse = AddressResponse.builder().response(addressSaved).status(HttpStatus.OK).build();
        return new ResponseEntity<AddressResponse>(addressResponse,HttpStatus.OK);
    }
}
