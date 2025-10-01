package com.study.spring_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring_basic.service.Coach;

@RestController
public class CoachController {
	private Coach myCoach;
	private Coach anotherCoach;
	
	/*
	 * @Autowired - In simple terms we use @Autowired annotation to tell spring : need an instance of this type, please find it & give it to me
	 * @Qualifier - If we have multiple implementation for coach then to avoid ambiguity @Qualifier is used
	 * We can use @Primary annotation as well on bean class , if we don't care which coach you just need coach object then we use primary
	 * */
	@Autowired
	//public CoachController(Coach theCoach) {
	public CoachController(@Qualifier("cricketCoach" )Coach theCoach,@Qualifier("cricketCoach" )Coach theAnotherCoach) {
		this.myCoach=theCoach;
		this.anotherCoach=theAnotherCoach;
	}
	
	@GetMapping("/dailyWorkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	@GetMapping("/check")
	public String check() {
	
		return "comparing beans : myCoach == anotherCoach : "+(myCoach==anotherCoach);
	}


}
