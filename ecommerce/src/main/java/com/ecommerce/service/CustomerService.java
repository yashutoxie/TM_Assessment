package com.ecommerce.service;
import com.ecommerce.entity.Customer;
import com.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {
    
    private final CustomerRepository customerRepository;
    
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    // Create
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
    // Read
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }
    
    public Optional<Customer> getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
    
    public List<Customer> getCustomersByNameContaining(String name) {
        return customerRepository.findByNameContaining(name);
    }
    
    // Update
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
    // Delete
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}