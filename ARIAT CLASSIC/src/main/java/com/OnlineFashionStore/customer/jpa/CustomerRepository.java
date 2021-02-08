package com.OnlineFashionStore.customer.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, String> {

	Customer findByEmailIdIgnoreCase(String emailId);
	
	@Query("SELECT c FROM Customer c WHERE CONCAT(c.firstName, ' ', c.lastName, ' ', c.dob, ' ', c.telephone, "
			+ "' ', c.emailId, ' ', c.province, ' ', c.district, ' ', c.city, ' ', "
			+ "c.street, ' ', c.userid) LIKE %?1%")
	 public List<Customer> search(String keyword);
	
	List<Customer> findAll();
	
	void deleteByEmailId(String emailId);
	void deleteByUserid(long userId);
	Customer findByUserid(long userId);
	
	@Query("SELECT province, COUNT(userid) FROM Customer GROUP BY userid")
	public List customersByProvinces();
}
