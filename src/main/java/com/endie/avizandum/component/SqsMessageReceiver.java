package com.endie.avizandum.component;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class SqsMessageReceiver {
    @SqsListener("${aws.sqs.queue-url}")
    public void receiveMessage(String message) {
        // Process the received message
        System.out.println("Received message: " + message);
    }
}
