package com.OnlineFashionStore.customer.jpa;


import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface InventoryRepository extends CrudRepository<Inventory, String> {

	
	Inventory findByItemNameIgnoreCase(String ItemName);
	List<Inventory> findAll();

	//void detelByItemName(String ItemName);
}
