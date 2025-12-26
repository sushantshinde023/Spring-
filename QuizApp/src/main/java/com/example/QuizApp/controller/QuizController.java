package com.example.QuizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuizApp.model.QuestionWrapper;
import com.example.QuizApp.model.Response;
import com.example.QuizApp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer noOfQuestion,@RequestParam String title ){
		
		return quizService.createQuiz(category,noOfQuestion,title);
	}
	
	@GetMapping("get/{quizId}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer quizId ){
		return quizService.getQuiz(quizId);
	}
	
	@PostMapping("submit/{quizId}")
	public ResponseEntity<Integer> submit(@PathVariable Integer quizId, @RequestBody List<Response> responses ){
		
		return quizService.calculateResult(quizId,responses);
	}
	

}
