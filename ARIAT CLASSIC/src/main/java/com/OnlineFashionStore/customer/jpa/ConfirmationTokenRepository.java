package com.OnlineFashionStore.customer.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {

	ConfirmationToken findByConfirmationToken(String confirmationToken);
	
	@Query("SELECT c FROM ConfirmationToken c WHERE CONCAT(c.tokenid, ' ', c.confirmationToken, ' ',"
			+ " c.createdDate) LIKE %?1%")
	public List<ConfirmationToken> search(String keyword);
	
	void deleteByConfirmationToken(String token);
}
