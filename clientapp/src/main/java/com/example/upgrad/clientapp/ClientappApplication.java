package com.example.upgrad.clientapp;

import com.example.upgrad.clientapp.RestTemplates.RestTemplateDemo;
import com.example.upgrad.clientapp.WebClientTemplates.WebClientDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ClientappApplication {
	public static String URI = "http://localhost:8080";
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ClientappApplication.class, args);

		WebClientDemo webClientDemo = applicationContext.getBean(WebClientDemo.class);
		webClientDemo.getUser("122");

	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	public WebClient webClient(){return WebClient.create("http://localhost:8080");
	}

}
