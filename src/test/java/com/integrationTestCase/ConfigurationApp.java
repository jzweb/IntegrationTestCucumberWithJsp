package com.integrationTestCase;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationApp {
	@Bean
	ServletWebServerFactory servletWebServerFactory(){
		  return new TomcatServletWebServerFactory();
		  }
	
}

