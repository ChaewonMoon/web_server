package com.MHE_Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * 
 * This project created by @author 문채원 on July,2018
 *
 */


@SpringBootApplication
@ComponentScan(basePackages={"com.MHE_Project.web", "com.MHE_Project.domain"})
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
