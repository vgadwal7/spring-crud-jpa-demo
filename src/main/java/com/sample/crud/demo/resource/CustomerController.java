package com.sample.crud.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

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
    public Customer getCustomerById(@PathVariable Long id) throws RuntimeException{
    	 return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer)throws RuntimeException {
    	try {
    		customerRepository.save(customer);
    	}catch(Exception e) {
    		throw new RuntimeException("Customer not created");
    	}
        return customer;
    }

    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer)throws RuntimeException{    	
    	try {
    		Customer existingCustomer = getCustomerById(id);
	    	existingCustomer.setFirstName(customer.getFirstName());
	    	existingCustomer.setMiddleName(customer.getMiddleName());
	    	existingCustomer.setLastName(customer.getLastName());
	    	existingCustomer.setEmailAddress(customer.getEmailAddress());
	    	existingCustomer.setPhoneNumber(customer.getPhoneNumber());
	    	customerRepository.save(existingCustomer);
    	}catch(Exception e) {
    		throw new RuntimeException("Customer not updated for id "+id);
    	}
        return customer;
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable Long id)throws HttpServerErrorException {
    	try {
    		customerRepository.deleteById(id);
    	}catch(Exception e) {
    		throw new RuntimeException("Customer delete failed for id "+id);
    	}
    }
}

