package com.training.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.model.Order;

@Service
public class OrderService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String producerUrl = "http://localhost:8081/bookstore/api/book/isbn/{isbn}";

	public Order createOrder(Long isbn,int qty)
	{
		HashMap<String,String> map=new HashMap<>();
		map.put("isbn", String.valueOf(isbn));
		
		Order order = restTemplate.getForObject(producerUrl, Order.class, map);
		order.setQty(qty);
		order.setAmount(order.getPrice() * qty);
		return order;
	}
}
