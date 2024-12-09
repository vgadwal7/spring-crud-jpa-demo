package com.sample.crud.demo;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.sample.crud.demo.persistence.Customer;

@SpringBootTest(classes = SpringCrudJpaDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringCrudJpaDemoApplicationTests {

	@LocalServerPort
	private int port;
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testRetrieveEmptyCustomers() throws JSONException {
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/customers"),
				HttpMethod.GET, entity, String.class);
		String expected = "{}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void testCreateCustomer() throws JSONException {
		Customer customer =new Customer("Test_First","Test_Middle","Test_Last","test@email.com","test288939905");
		HttpEntity<Customer> entity = new HttpEntity<>(new Customer("Test_First","Test_Middle","Test_Last","test@email.com","test288939905"), headers);
		ResponseEntity<Customer> response = restTemplate.exchange(createURLWithPort("/api/customer"),
				HttpMethod.POST, entity, Customer.class);		
		JSONAssert.assertEquals(customer.getFirstName(),response.getBody().getFirstName(),true);
		JSONAssert.assertEquals(customer.getLastName(),response.getBody().getLastName(),true);
		JSONAssert.assertEquals(customer.getMiddleName(),response.getBody().getMiddleName(),true);
		JSONAssert.assertEquals(customer.getEmailAddress(),response.getBody().getEmailAddress(),true);
		JSONAssert.assertEquals(customer.getPhoneNumber(),response.getBody().getPhoneNumber(),true);
		
	}
	
	@Test
	public void testGetCustomerById() throws JSONException {
		Customer customer =new Customer("Test_First","Test_Middle","Test_Last","test@email.com","test288939905");
		HttpEntity<Customer> entity = new HttpEntity<>(new Customer("Test_First","Test_Middle","Test_Last","test@email.com","test288939905"), headers);
		ResponseEntity<Customer> postCustomerResponse = restTemplate.exchange(createURLWithPort("/api/customer"),
				HttpMethod.POST, entity, Customer.class);	
		
		
		Customer createdCustomer =postCustomerResponse.getBody();
		HttpEntity<Customer> entityForPut = new HttpEntity<>(createdCustomer, headers);
		ResponseEntity<Customer> response = restTemplate.exchange(createURLWithPort("/api/customer/"+createdCustomer.getId()),
				HttpMethod.GET, entityForPut, Customer.class);	
		JSONAssert.assertEquals(customer.getFirstName(),response.getBody().getFirstName(),true);
		JSONAssert.assertEquals(customer.getLastName(),response.getBody().getLastName(),true);
		JSONAssert.assertEquals(customer.getMiddleName(),response.getBody().getMiddleName(),true);
		JSONAssert.assertEquals(customer.getEmailAddress(),response.getBody().getEmailAddress(),true);
		JSONAssert.assertEquals(customer.getPhoneNumber(),response.getBody().getPhoneNumber(),true);
		
	}
	
	@Test
	public void testPutCustomer() throws JSONException {
		Customer customer =new Customer("Test_First","Test_Middle","Test_Last","test@email.com","test288939905");
		HttpEntity<Customer> entity = new HttpEntity<>(new Customer("Test_First","Test_Middle","Test_Last","test@email.com","test288939905"), headers);
		ResponseEntity<Customer> postCustomerResponse = restTemplate.exchange(createURLWithPort("/api/customer"),
				HttpMethod.POST, entity, Customer.class);	
		
		
		Customer createdCustomer =postCustomerResponse.getBody();
		HttpEntity<Customer> entityForPut = new HttpEntity<>(createdCustomer, headers);
		ResponseEntity<Customer> response = restTemplate.exchange(createURLWithPort("/api/customer/"+createdCustomer.getId()),
				HttpMethod.POST, entityForPut, Customer.class);	
		JSONAssert.assertEquals(customer.getFirstName(),response.getBody().getFirstName(),true);
		JSONAssert.assertEquals(customer.getLastName(),response.getBody().getLastName(),true);
		JSONAssert.assertEquals(customer.getMiddleName(),response.getBody().getMiddleName(),true);
		JSONAssert.assertEquals(customer.getEmailAddress(),response.getBody().getEmailAddress(),true);
		JSONAssert.assertEquals(customer.getPhoneNumber(),response.getBody().getPhoneNumber(),true);
		
	}
	
	@Test
	public void testDeleteCustomer() throws JSONException {
		Customer customer =new Customer("Test_First","Test_Middle","Test_Last","test@email.com","test288939905");
		HttpEntity<Customer> entity = new HttpEntity<>(new Customer("Test_First","Test_Middle","Test_Last","test@email.com","test288939905"), headers);
		ResponseEntity<Customer> postCustomerResponse = restTemplate.exchange(createURLWithPort("/api/customer"),
				HttpMethod.POST, entity, Customer.class);	
		
		
		Customer createdCustomer =postCustomerResponse.getBody();
		HttpEntity<Customer> entityForDelete = new HttpEntity<>(createdCustomer, headers);
		restTemplate.exchange(createURLWithPort("/api/customer/"+createdCustomer.getId()),
				HttpMethod.DELETE, entityForDelete, Customer.class);
		
		ResponseEntity<Customer> response = restTemplate.exchange(createURLWithPort("/api/customer/"+createdCustomer.getId()),
				HttpMethod.GET, entityForDelete, Customer.class);
		JSONAssert.assertEquals(null,response.getBody().getFirstName(),true);
		
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
