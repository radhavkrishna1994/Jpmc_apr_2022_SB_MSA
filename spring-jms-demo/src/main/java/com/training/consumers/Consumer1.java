package com.training.consumers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer1 {
	
	/*
	 * @JmsListener(destination = "test-queue-external") public void
	 * receiveMessage(String message) {
	 * System.out.println("Message Received:"+message); }
	 */

}
