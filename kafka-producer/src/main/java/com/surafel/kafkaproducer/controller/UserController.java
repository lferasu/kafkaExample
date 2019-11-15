package com.surafel.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class UserController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    KafkaTemplate<String, User> kafkaPostTemplate;

    public String TOPIC = "QUEUE";

    @GetMapping("/publish/{message}")
    public String post(@PathVariable("message") final String message) {
        kafkaTemplate.send(TOPIC, message);

        return "published succesfully";
    }

    @PostMapping
    @RequestMapping("/publish")
    public String postMessage(@RequestBody User user) {
        kafkaPostTemplate.send(TOPIC, user);
        return user.toString();
    }


}
