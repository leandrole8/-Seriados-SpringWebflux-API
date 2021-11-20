package com.digitalinnovationone.seriados;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class SeriadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeriadosApplication.class, args);
		System.out.println("Os melhores seriados com webflux.");
	}

}
