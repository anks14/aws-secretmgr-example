package com.example.demo;


import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecretsManager {


    @Value("${secret.region}")
    private String region;

    @Value("${secret.name}")
    private String secretName;


    @Bean
    public GetSecretValueResult getSecret() {
        try {
            AWSSecretsManager awsSecretsManager = AWSSecretsManagerClientBuilder.standard().withRegion(region).build();
            GetSecretValueRequest secretValueRequest = new GetSecretValueRequest()
                    .withSecretId(secretName);
            return awsSecretsManager.getSecretValue(secretValueRequest);
        } catch (Exception ex) {

            throw new RuntimeException("Cannot retrieve secret for" + secretName);
        }
    }

}
