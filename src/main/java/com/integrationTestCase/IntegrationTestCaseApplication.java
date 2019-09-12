package com.integrationTestCase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages= {	"com.integrationTestCase",
								"com.integrationTestCase.model",
								"com.integrationTestCase.restController",
								"com.integrationTestCase.service",
								"com.integrationTestCase.templateController"})	
@SpringBootApplication
public class IntegrationTestCaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationTestCaseApplication.class, args);
	}

}
