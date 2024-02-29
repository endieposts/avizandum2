package com.endie.avizandum;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "aws")
public class AwsProperties {

    private String accessKey;
    private String secretKey;
    private String region;

    private Sqs sqs;

    // Getters and Setters

    public static class Sqs {
        private String queueUrl;

        // Getters and Setters
    }
}
