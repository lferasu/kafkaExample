package com.surafel.kafkaconsumer.listners;

import com.surafel.kafkaconsumer.Model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListner {

    @KafkaListener(topics = "QUEUE" , groupId = "group_id")
    public void consume(String message) {
        System.out.println("Hello " + message);
    }

    @KafkaListener(topics = "QUEUE" , groupId = "group_id")
    public void consumeUser (User user) {
        System.out.println(user.toString());
    }

}
