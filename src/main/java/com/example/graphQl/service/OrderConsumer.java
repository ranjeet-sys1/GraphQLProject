package com.example.graphQl.service;


import com.example.graphQl.DTO.Order;
import com.example.graphQl.configuration.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveOrder(Order order) {

        System.out.println("Received Order: " + order.getProduct());
    }
}
