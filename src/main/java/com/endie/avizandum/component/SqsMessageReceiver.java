package com.endie.avizandum.component;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;
import com.endie.avizandum.AwsProperties;

@Component
public class SqsMessageReceiver {

    private final AwsProperties awsProperties;

    public SqsMessageReceiver(AwsProperties awsProperties) {
        this.awsProperties = awsProperties;
    }

    @SqsListener("${aws.sqs.queue-url}")
    public void receiveMessage(String message) {
        // Process the received message
        System.out.println("Received message: " + message);
    }
}
