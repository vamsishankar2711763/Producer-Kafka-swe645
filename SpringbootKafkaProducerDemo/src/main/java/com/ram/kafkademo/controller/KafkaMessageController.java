package com.ram.kafkademo.controller;

import com.ram.kafkademo.model.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ram.kafkademo.service.KafkaProducerService;

@RestController
public class KafkaMessageController
{
   
    @Autowired
	private KafkaProducerService kafkaProducerService;
 
    @PostMapping("/publish")
    public String publishMessage(@RequestBody Form form)
    {
    	kafkaProducerService.sendMessage(form);
		System.out.println("Successfully Published the Form = '" + form + "' to the FormsTopic");
		return "Successfully Published the Forms = '" + form + "' to the FormsTopic";
    }
}
