package com.OnlineFashionStore.customer.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {

	Product findByProductCodeIgnoreCase(String product_code);
	List<Product> findAll();
	void deleteByProductCode(String product_code);

}
