package com.study.spring_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring_basic.service.Car;

@RestController
public class CarController {
	
	private Car car;
	
	@Autowired
	public void setCar(Car theCar) {
		this.car=theCar;
	}
	
	@GetMapping("/car")
	public String getCar() {
		return car.getCar();
	}

}
