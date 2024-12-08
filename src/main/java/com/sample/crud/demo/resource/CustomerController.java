package com.sample.crud.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sample.crud.demo.persistence.Customer;
import com.sample.crud.demo.persistence.CustomerRepository;

import java.util.List;


@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
    	 return customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
    	 return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
    	return customerRepository.save(customer);
    }

    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
    	Customer existingCustomer = getCustomerById(id);
    	existingCustomer.setFirstName(customer.getFirstName());
    	existingCustomer.setMiddleName(customer.getMiddleName());
    	existingCustomer.setLastName(customer.getLastName());
    	existingCustomer.setEmailAddress(customer.getEmailAddress());
    	existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        return customerRepository.save(existingCustomer);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
    	customerRepository.deleteById(id);
    }
}

