package com.OnlineFashionStore.customer.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PaymentReporsitory extends CrudRepository<Payment, String> {
	
	List<Payment> findAll();

}
