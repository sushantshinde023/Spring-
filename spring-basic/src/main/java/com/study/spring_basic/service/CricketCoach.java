package com.study.spring_basic.service;

import org.springframework.stereotype.Component;
/*
 * @Component annotation marks the class as spring bean and it marks the bean as available for DI
 * A spring bean is just a regular java class that is managed by Spring
 * 
 * */
@Component
public class CricketCoach implements Coach {

	@Override
	public String getDailyWorkout() {
	
		return "Do net practice for batting for an Hour";
	}

}
