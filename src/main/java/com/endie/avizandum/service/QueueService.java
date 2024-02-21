package com.endie.avizandum.service;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SqsException;
import software.amazon.awssdk.services.sqs.paginators.ListQueuesIterable;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;

@Service
public class QueueService {

    //instantiate connection to AWS
    SqsClient sqsClient = SqsClient.builder()
            .region(Region.US_WEST_2)
            .build();

    public void addTurnToQueue() {

    }

}
