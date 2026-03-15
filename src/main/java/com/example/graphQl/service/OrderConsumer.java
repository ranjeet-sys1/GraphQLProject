package com.example.graphQl.service;


import com.example.graphQl.DTO.Order;
import com.example.graphQl.configuration.RabbitMQConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveOrder(Order order) {

        System.out.println("Received Order: " + order.getProduct());
    }
    @RabbitListener(queues = "order_queue")
    public void consume(Message message, Channel channel) throws Exception {

        long tag = message.getMessageProperties().getDeliveryTag();

        try {

            String msg = new String(message.getBody());

            System.out.println("Received: " + msg);

            if (msg.contains("fail")) {
                throw new RuntimeException("Processing failed");
            }

            channel.basicAck(tag, false);

        } catch (Exception e) {

            System.out.println("Error occurred");

            channel.basicNack(tag, false, false);
        }

    }
}
