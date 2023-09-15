package com.jhola;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServiceMicroservicesApplication.class, args);
	}

}
