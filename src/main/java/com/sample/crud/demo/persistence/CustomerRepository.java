package com.sample.crud.demo.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to handle crud ops for customer
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

