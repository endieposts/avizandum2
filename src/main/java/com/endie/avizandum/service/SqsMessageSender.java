package com.endie.avizandum.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
public class SqsMessageSender {
    private final SqsAsyncClient sqsAsyncClient;
    private final String queueUrl;
    public SqsMessageSender(SqsAsyncClient sqsAsyncClient, @Value("${aws.sqs.queue-url}") String queueUrl) {
        this.sqsAsyncClient = sqsAsyncClient;
        this.queueUrl = queueUrl;
    }
    public void sendMessage(String message) {
        sqsAsyncClient.sendMessage(SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(message)
                .build());
    }
}
