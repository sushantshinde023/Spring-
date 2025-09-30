package com.study.spring_basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 * @RestController is a specialized version of @Controller and @ResponseBody annotation
 * Making it fundamental for building RESTFul web services
 * It Serves two main purpose
 * 1. Stereotype : It marks a class as spring bean that plays the role of controller. This means the class is responsible for handling incoming web requests.
 * 2. Data Handling : Crucially it automatically adds the functionality of @ResponseBody annotation to every method within the controller class.
 * Difference @Controller vs @RestController
 * @Controller - Used for traditional MVC, typically returns a view name
 * @RestController - Used for REST APIs,automatically implies @ResponseBody (return data directly e.g. JSON)
 * */
@RestController
public class HelloWorldController {
	/*
	 * @GetMapping - annotation in spring boot and spring mvc is a convenience annotation that is used to map HTTP GET requests to specific handler method
	 * It is shorthand equivalent of using @RequestMapping(method = RequestMethod.GET)
	 * The value provided to @GetMapping defines the URI path that the method will handle
	 * GET request are  expected to be idempotent, meaning performing the same request multiple times should have the same effect as performing it once
	 * */
	@GetMapping("/")
	public String syaHello() {
		return "Hello World!";
	}
	

}
