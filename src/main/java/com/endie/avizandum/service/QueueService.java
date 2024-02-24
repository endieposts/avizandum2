package com.endie.avizandum.service;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

@Service
public class QueueService {
    private final SqsClient sqsClient;
    private final String queueUrl;

    public QueueService(String queueUrl) {
        this.sqsClient = SqsClient.create();
        this.queueUrl = queueUrl;
    }

    public void addPlayerTurn(String playerTurn) {
        SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(playerTurn)
                .build();
        sqsClient.sendMessage(sendMessageRequest);
    }

    public String readPlayerTurn() {
        ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .maxNumberOfMessages(1)
                .build();
        ReceiveMessageResponse receiveMessageResponse = sqsClient.receiveMessage(receiveMessageRequest);
        Message message = receiveMessageResponse.messages().get(0);
        return message.body();
    }
}
