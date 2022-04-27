package com.training.consumers;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.training.model.Order;

/*
 * @KafkaListener(id = "bar", topicPartitions =
    { @TopicPartition(topic = "topic1", partitions = { "0", "1" }),
      @TopicPartition(topic = "topic2", partitions = "0",
         partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "100"))
    })
 */

@Component
public class KafkaConsumer {

	@KafkaListener(topics="jpmc_002_topic")
	public void receiveOrders(List<Order> orders)
	{
		System.out.println("Orders received:"+orders);
	}
}
