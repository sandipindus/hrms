package com.easybusiness.hrmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class HRManagmentapplicationApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HRManagmentapplicationApplication.class);
	}
	 
	public static void main(String[] args) {
		SpringApplication.run(HRManagmentapplicationApplication.class, args);
	}
	
	
}
