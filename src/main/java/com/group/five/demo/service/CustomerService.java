package com.group.five.demo.service;

import com.group.five.demo.entitiy.Customer;
import com.group.five.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<Customer> save(Customer customer) {
        return ResponseEntity.ok(customerRepository.save(customer));
    }

    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerRepository.findAll());
    }

    public ResponseEntity<Customer> findById(Integer id) {
        return ResponseEntity.ok(customerRepository.findById(id).orElse(null));
    }
}
