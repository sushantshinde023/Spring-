package com.example.QuizApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuizApp.model.Question;
import com.example.QuizApp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/allQuestions")
	public List<Question> getAllQuestions(){
		return questionService.getAllQuestions();
	}
	@GetMapping("/question/{id}")
	public Optional<Question> getAllQuestions(@PathVariable Integer id){
		return questionService.getQuestion(id);
	}
	
	@GetMapping("/category/{category}")
	public List<Question> getQuestionByCategory(@PathVariable String category){
		return questionService.getQuestionByCategory(category);
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> addQuestion(@RequestBody Question question ) {
		return questionService.addQuestion(question);
	}
	
	@PutMapping("/update")
	public String updateQuestion(@RequestBody Question question ) {
		//Optional<Question> question=questionService.getQuestion(question.getId());
		return null;
	}

}
