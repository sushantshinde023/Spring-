package com.study.spring_basic.service;

import org.springframework.stereotype.Component;

@Component
public class Maruti implements Car {

	@Override
	public String getCar() {
		return "Swift DZire";
	}

}
