package org.akj.springboot.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Springboot application - Entry point
 * 
 * @author Jamie Y L Zhang
 */

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "org.akj.springboot")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
