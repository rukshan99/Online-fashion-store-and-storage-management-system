package com.OnlineFashionStore.customer.jpa;

import org.springframework.data.repository.CrudRepository;


public interface DeliveryRepository extends CrudRepository<Delivery, String> {

	Delivery findByOrderIdIgnoreCase(String OrderId);

}
