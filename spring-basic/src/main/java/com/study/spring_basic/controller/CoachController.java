package com.study.spring_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring_basic.service.Coach;

@RestController
public class CoachController {
	private Coach myCoach;
	
	/*
	 * @Autowired - In simple terms we use @Autowired annotation to tell spring : need an instance of this type, please find it & give it to me
	 * */
	@Autowired
	public CoachController(Coach theCoach) {
		this.myCoach=theCoach;
	}
	
	@GetMapping("/dailyWorkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}

}
