package com.example.graphQl.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @RabbitListener(queues = "demo_queue")
    public void receive(String message) {
        System.out.println("Received: " + message);
    }
}