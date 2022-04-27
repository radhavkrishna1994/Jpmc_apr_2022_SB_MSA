package com.training.services;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.training.model.Order;

@Service
public class JmsService {
	
	@Autowired
	private ActiveMQQueue queue;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public String publishMessage(String message)
	{
		jmsTemplate.convertAndSend(queue, message);
		return message +" is published";
	}
	
	public String publishOrder(Order order)
	{
		jmsTemplate.convertAndSend(queue, order);
		return order + " is published";
	}

}
