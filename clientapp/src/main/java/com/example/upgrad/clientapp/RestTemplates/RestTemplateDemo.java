package com.example.upgrad.clientapp.RestTemplates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.AsyncRestOperations;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateDemo {
    //@Autowired
    RestTemplate restTemplate;

    public void printData() {
        String uri = "http://localhost:8080/controllerone/getuser/1";

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        System.out.println(responseEntity.getBody());
    }
}
