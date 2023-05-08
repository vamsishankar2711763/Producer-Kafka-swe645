package com.ram.kafkademo.service;

import com.ram.kafkademo.model.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService
{
	@Autowired
	private KafkaTemplate<String, Form> kafkaTemplate;
	
	private final static String TOPIC_NAME = "FormsTopic";

	public void sendMessage(Form form)
	{
		kafkaTemplate.send(TOPIC_NAME,form);
	}
}
