package com.ensi.ilsi.AirlineCompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
	
@EnableConfigurationProperties
//@EnableDiscoveryClient
@EnableSwagger2
@SpringBootApplication
public class AirlineCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineCompanyApplication.class, args);
	}
}
