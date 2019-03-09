package com.techprimers.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients("com.techprimers.stock")
public class ProjectTaskServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectTaskServiceApplication.class, args);
	}

}

