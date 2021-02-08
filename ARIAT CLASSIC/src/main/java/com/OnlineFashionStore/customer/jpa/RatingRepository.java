package com.OnlineFashionStore.customer.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface RatingRepository extends CrudRepository<Rating, String> {

	Rating findByEmailIgnoreCase(String Email);
	List<Rating> findAll();
	
}

