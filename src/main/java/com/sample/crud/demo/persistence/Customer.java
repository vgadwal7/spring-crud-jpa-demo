package com.sample.crud.demo.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName",nullable = false)
    private String firstName;
    @Column(name = "middleName",nullable = true)
    private String middleName;
    @Column(name = "lastName",nullable = false)
    private String lastName;
    @Column(name = "emailAddress",nullable = false)
    private String emailAddress;
    @Column(name = "phoneNumber",nullable = false)
    private String phoneNumber;
    
    public Customer() {

    }

    public Customer(String firstName, String middleName,String lastName, String emailAddress, String phoneNumber) {
      this.firstName = firstName;
      this.middleName = middleName;
      this.lastName = lastName;
      this.emailAddress = emailAddress;
      this.phoneNumber = phoneNumber;      
    }

    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}

