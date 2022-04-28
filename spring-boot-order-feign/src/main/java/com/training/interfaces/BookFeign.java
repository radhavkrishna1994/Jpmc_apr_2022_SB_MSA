package com.training.interfaces;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.training.model.Order;

@FeignClient(name="book-producer-service")
@LoadBalancerClient(name="book-producer-service")
public interface BookFeign {

	
	//http://localhost:8081/bookstore/api/book/isbn/1234
	@GetMapping("/bookstore/api/book/isbn/{isbn}")
	public Order createOrderFeign(@PathVariable("isbn") Long isbn);//,@RequestHeader("Authorization") String header);
	
}
