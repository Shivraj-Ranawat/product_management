package com.product_management.service;

import com.product_management.model.Customer;
import com.product_management.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImplmentation implements CustomerService {
    @Autowired
    private CustomerRepository customer_Repository;
    @Override
    public Customer saveCustomer(Customer customer) {
        return customer_Repository.save(customer);
    }


}
