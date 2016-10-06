package com.sjsu.cmpe282.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TaskProducer {
	@Autowired
	private TaskProducerConfiguration taskProducerConfiguration;

	public void sendNewTask(TaskMessage taskMessage) {
		System.out.println("Sending message from task producer!!");
		byte[] data = taskMessage.getEmailId().getBytes();
		System.out.println("TASK PRODUCER BYTE DATA "+data);
		taskProducerConfiguration.rabbitTemplate().convertAndSend(
				taskProducerConfiguration.tasksQueue, data);
		System.out.println("Successfully sent message from task producer!!"); 
	}

}
