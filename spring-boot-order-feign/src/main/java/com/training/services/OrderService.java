package com.training.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.interfaces.BookFeign;
import com.training.model.Order;

@Service
public class OrderService {
	
	@Autowired
	private BookFeign bookFeign;
	
	
	public Order createOrder(Long isbn,int qty)
	{
		Order order = bookFeign.createOrderFeign(isbn);
		order.setQty(qty);
		order.setAmount(order.getPrice() * qty);
		
		return order;
	}
}
