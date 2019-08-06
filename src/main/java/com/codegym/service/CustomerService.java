package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface CustomerService {
    Iterable<Customer> findAll();
    Customer findById(Long id);
    void save(Customer customer);
    void delete(Long id);
}
