package com.example.graphQl.service;


import com.example.graphQl.DTO.Order;
import com.example.graphQl.configuration.RabbitMQConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrder(Order order) {

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.ROUTING_KEY,
                order
        );

        System.out.println("Order sent: " + order.getProduct());
    }
    @PostConstruct
    public void init() {

        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {

            if (ack) {
                System.out.println("Message delivered to broker");
            } else {
                System.out.println("Message delivery failed: " + cause);
            }

        });
    }
    public void sendMessage(String message) {

        rabbitTemplate.convertAndSend("order_queue", message);

    }
}