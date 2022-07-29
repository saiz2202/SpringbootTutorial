package com.example.spring.springprojects.service;

import com.example.spring.springprojects.entity.Address;
import com.example.spring.springprojects.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository){
        this.addressRepository=addressRepository;
    }

    public Address saveAddress(Address address){
       return addressRepository.save(address);
    }
}
