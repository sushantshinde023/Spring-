package com.study.spring_basic.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class TrackCoach implements Coach {
	public TrackCoach() {
		System.out.println("In constructor "+getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
	
		return "Run daily at least 5km";
	}

}
