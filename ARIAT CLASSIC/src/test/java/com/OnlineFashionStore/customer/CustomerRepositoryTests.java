package com.OnlineFashionStore.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.test.annotation.Rollback;

import com.OnlineFashionStore.customer.jpa.Customer;
import com.OnlineFashionStore.customer.jpa.CustomerRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class CustomerRepositoryTests {

	@Autowired
    private CustomerRepository repo;
	
	
	/*
	 * Test Create operation of CustomerRepository
	 */
	@Test
	@Rollback(false)
	@Order(1)
	public void testCreateCustomer() {
	    Customer savedCustomer = repo.save(new Customer(1, "rukshan@ariat.com", "$2a$10$QrQ4cEbXxqHxBJOSx6jy8u2WQBJMzRSyZ2PnQtDCV4kOWJ32yv0jy", "Rukshan", "Jayasekara", "1999-11-07",
				"0763754996", "Colombo Road", "Gampaha", "Gampaha", "Western", true, "USER"));
	     
	    assertThat(savedCustomer.getUserid()).isGreaterThan(0);
	}
	
	
	
	/*
	 * Test Retrieve operations of CustomerRepository
	 */
	@Test
	@Order(2)
	public void testfindByEmailIdIgnoreCase() {
		Customer customer = repo.findByEmailIdIgnoreCase("rukshan@ariat.com");    
	    assertThat(customer.getEmailId()).isEqualTo("rukshan@ariat.com");
	}
	
	@Test
	@Order(3)
	public void testListCustomers() {
	    List<Customer> customer = (List<Customer>) repo.findAll();
	    assertThat(customer).size().isGreaterThan(0);
	}
	
	
	
	/*
	 * Test Update operation of CustomerRepository
	 */
	@Test
	@Rollback(false)
	@Order(4)
	public void testUpdateCustomer() {
		Customer customer = repo.findByEmailIdIgnoreCase("rukshan@ariat.com");
		customer.setFirstName("Thilina");
	     
	    repo.save(customer);
	     
	    Customer updatedCustomer = repo.findByEmailIdIgnoreCase("rukshan@ariat.com");
	     
	    assertThat(updatedCustomer.getFirstName()).isEqualTo("Thilina");
	}
	
	
	
	/*
	 * Test Delete operation of CustomerRepository
	 */
	@Test
	@Rollback(false)
	@Order(5)
	public void testDeleteCustomer() {
		Customer customer = repo.findByEmailIdIgnoreCase("rukshan@ariat.com");
	     
	    repo.deleteByUserid(customer.getUserid());
	     
	    Customer deletedCustomer = repo.findByEmailIdIgnoreCase("rukshan@ariat.com");
	     
	    assertThat(deletedCustomer).isNull();       
	     
	}
}
