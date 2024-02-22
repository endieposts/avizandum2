package com.endie.avizandum.service;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.*;
import software.amazon.awssdk.services.sqs.model.SqsException;
import software.amazon.awssdk.services.sqs.paginators.ListQueuesIterable;

@Service
public class QueueService {

    //instantiate connection to AWS
    SqsClient sqsClient = SqsClient.builder()
            .region(Region.US_WEST_2)
            .build();

    public void addTurnToQueue() {

        //Get the sqs queue url
        String queueUrl = getQueueUrl("avizandum-queue");

    }

    private String getQueueUrl(String s) {
        try {
            ListQueuesIterable listQueues = sqsClient.listQueuesPaginator();

            for (software.amazon.awssdk.services.sqs.model.ListQueuesResponse queue : listQueues) {
                if (queue.queueUrls().contains(s)) {
                    return queue.queueUrls().get(0);
                }
            }
        } catch (SqsException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        return "";
    }

    public void sendMessage(String queueUrl, String message) {
        try {
            sqsClient.sendMessage(s -> s.queueUrl(queueUrl).messageBody(message));
        } catch (SqsException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

}
