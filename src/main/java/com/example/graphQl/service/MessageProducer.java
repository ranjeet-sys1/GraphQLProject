package com.example.graphQl.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send() {
        rabbitTemplate.convertAndSend("demo_queue", "Hello RabbitMQ");
    }
}