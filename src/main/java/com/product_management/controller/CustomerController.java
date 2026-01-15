package com.product_management.controller;

import com.product_management.model.Customer;
import com.product_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerservice;
    @PostMapping("/saveCustomer")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer){

        return new ResponseEntity<>(customerservice.saveCustomer(customer), HttpStatus.CREATED);
    }

}
