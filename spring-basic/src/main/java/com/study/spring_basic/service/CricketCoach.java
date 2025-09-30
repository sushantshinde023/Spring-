package com.study.spring_basic.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
/*
 * @Component annotation marks the class as spring bean and it marks the bean as available for DI
 * A spring bean is just a regular java class that is managed by Spring
 * 
 * @Lazy we use lazy initialization instead of creating all beans up front
 * The bean will be initialized in following cases
 * 1. It is needed for dependency injection
 * 2. It is explicitly requested
 * */
@Component
//@Lazy
public class CricketCoach implements Coach {
	
	public CricketCoach() {
		System.out.println("In constructor "+getClass().getSimpleName());// it will not get initialized as we marked it as @Lazy, and TrachCoach is primary
	}

	@Override
	public String getDailyWorkout() {
	
		return "Do net practice for batting for an Hour";
	}

}
