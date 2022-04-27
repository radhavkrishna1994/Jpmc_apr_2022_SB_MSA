package com.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.training.model.Order;

@Service
public class KafkaProducerService {

	
	private static final String KAFKATOPIC="jpmc_002_topic";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private KafkaTemplate<String, List<Order>> kafkaTemplateOrder;
	
	public String publishMessage(String message)
	{
		kafkaTemplate.send(KAFKATOPIC,message);
		return "message published";
	}
	
	public String publishOrder(List<Order> orders)
	{
		kafkaTemplateOrder.send(KAFKATOPIC,orders);
		return orders+": published";
	}
	
	
	
	
}
