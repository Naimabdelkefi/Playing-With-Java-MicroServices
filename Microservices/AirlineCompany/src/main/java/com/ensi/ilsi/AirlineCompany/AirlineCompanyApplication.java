package com.ensi.ilsi.AirlineCompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableConfigurationProperties
@SpringBootApplication
@EnableDiscoveryClient
public class AirlineCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineCompanyApplication.class, args);
	}
}
