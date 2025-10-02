package com.study.hibernate_crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateCrudApplication.class, args);
	}
	
	/*
	 * We are creating Spring boot command line App , this will allow us to focus on Hibernate/JPA
	 * The commandLineRunner is a spring boot bean that implements the CommandLineRunner Interface
	 * It is used to execute custom logic after the application context is initialized & application has started.
	 * */
	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner->{
			System.out.println("Hello World");
		};
	}

}
