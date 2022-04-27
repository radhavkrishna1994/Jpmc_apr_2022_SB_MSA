package com.training.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

	
	private static final String KAFKATOPIC="jpmc_001_topic";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public String publishMessage(String message)
	{
		kafkaTemplate.send(KAFKATOPIC,message);
		return "message published";
	}
	
	
	
}
