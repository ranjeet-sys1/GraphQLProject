package com.example.graphQl.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DLQConsumer {

    @RabbitListener(queues = "order_dlq")
    public void processFailed(String message) {

        System.out.println("Message in DLQ: " + message);

    }

}