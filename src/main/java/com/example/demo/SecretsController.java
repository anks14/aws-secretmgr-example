package com.example.demo;


import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
public class SecretsController {


    @Autowired
    private GetSecretValueResult getSecretValueResult;


    @GetMapping("/getSecret")
    public String getSecret() {
        String secret = "";

        if (getSecretValueResult.getSecretString() != null) {
            secret = getSecretValueResult.getSecretString();

        } else {
            secret = new String(Base64.getDecoder().decode(getSecretValueResult.getSecretBinary()).array());
        }
        return secret;
    }


}
