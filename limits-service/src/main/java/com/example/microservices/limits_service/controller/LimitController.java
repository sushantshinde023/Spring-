package com.example.microservices.limits_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.limits_service.config.PropertiesConfiguration;
import com.example.microservices.limits_service.model.Limits;

@RestController
public class LimitController {
	@Autowired
	private PropertiesConfiguration config;
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		
		return new Limits(config.getMin(),config.getMax());
		//return new Limits(1,1000);
	}

}
