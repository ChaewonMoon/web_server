package com.MHE_Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@ComponentScan(basePackages={"net.MHE_Project.web"})
@EnableAutoConfiguration
public class MheProjectApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MheProjectApplication.class, args);
	}
	/*
	@Bean
	public InternalResourceViewResolver setupViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
			resolver.setPrefix("WEB-INF/view");
			resolver.setSuffix(".jsp");
			return resolver;
	}
	*/
}
