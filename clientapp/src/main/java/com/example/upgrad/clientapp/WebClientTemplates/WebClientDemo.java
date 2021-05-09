package com.example.upgrad.clientapp.WebClientTemplates;

import com.example.upgrad.clientapp.Resources.userObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class WebClientDemo {
    public static String URI = "http://localhost:8080";

    WebClient webClient = WebClient.create(URI);

    public void getUser(String userId) {
        String userRelativeURI = "/controllerone/";

        Mono<userObject> result = webClient
                                    .get()
                                    .uri(userRelativeURI+"getuser/"+userId)
                                    .retrieve()
                                    .bodyToMono(userObject.class);
        System.out.println(result.block());
    }
}
