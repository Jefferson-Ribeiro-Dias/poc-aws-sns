package com.exemplo.jeff.sqs.poc.springbootsns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootSnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSnsApplication.class, args);
	}

}
