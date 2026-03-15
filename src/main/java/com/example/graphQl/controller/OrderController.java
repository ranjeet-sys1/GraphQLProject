package com.example.graphQl.controller;


import com.example.graphQl.DTO.Order;
import com.example.graphQl.service.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderProducer producer;

    public OrderController(OrderProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String createOrder(@RequestBody Order order) {

        producer.sendOrder(order);

        return "Order sent to RabbitMQ";
    }
    @PostMapping
    public String send(@RequestBody String msg) {

        producer.sendMessage(msg);

        return "Message sent";

    }
}