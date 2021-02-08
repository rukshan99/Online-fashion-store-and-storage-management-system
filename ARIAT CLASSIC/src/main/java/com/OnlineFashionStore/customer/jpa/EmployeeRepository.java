package com.OnlineFashionStore.customer.jpa;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

		Employee findByEmployeeEmailIgnoreCase(String email);
		
	}


