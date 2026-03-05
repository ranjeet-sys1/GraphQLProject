package com.example.graphQl.controller;


import com.example.graphQl.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    MessageProducer producer;

    @GetMapping("/send")
    public String sendMessage() {
        producer.send();
        return "Message Sent";
    }
}