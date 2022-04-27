package com.training.consumers;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.training.model.Order;

@Component
public class KafkaConsumer {

	@KafkaListener(topics="jpmc_002_topic")
	public void receiveOrders(List<Order> orders)
	{
		System.out.println("Orders received:"+orders);
	}
}
