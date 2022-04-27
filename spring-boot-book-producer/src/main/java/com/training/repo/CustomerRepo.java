package com.training.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.model.Customer;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, Long>{

	@Query("{name : ?0}")
	public List<Customer> getCustomer(String name);
	
	@Query("{points : {$gt: ?0}}")
	public List<Customer> getCustomersPoints(int points);
	
}
