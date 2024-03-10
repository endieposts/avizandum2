package com.endie.avizandum.component;

import com.endie.avizandum.AwsProperties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;

import static org.mockito.Mockito.verify;

public class SqsMessageReceiverTest {

    @Mock
    private AwsProperties awsProperties;

    @InjectMocks
    private SqsMessageReceiver sqsMessageReceiver;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void receiveMessage_ValidMessage_ProcessesMessage() {
        String message = "Test message";
        sqsMessageReceiver.receiveMessage(message);
        //verify(sqsMessageReceiver).receiveMessage(message);

        System.out.println("Received message: " + message);
    }
}