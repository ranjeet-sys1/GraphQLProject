package com.example.graphQl.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE = "order_queue";
    public static final String EXCHANGE = "order_exchange";
    public static final String ROUTING_KEY = "order.created";
    public static final String DLQ = "order_dlq";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE, true); // durable queue
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(ROUTING_KEY);
    }
    @Bean
    public Queue mainQueue() {

        Map<String, Object> args = new HashMap<>();

        args.put("x-dead-letter-exchange", "");
        args.put("x-dead-letter-routing-key", DLQ);

        return new Queue(QUEUE, true, false, false, args);
    }

    @Bean
    public Queue deadLetterQueue() {
        return new Queue(DLQ, true);
    }
}