package com.example.QuizApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.QuizApp.dao.QuestionRepository;
import com.example.QuizApp.model.Question;

import jakarta.transaction.Transactional;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository questionRepo;
	
	
	public List<Question> getAllQuestions(){
		return questionRepo.findAll();
	}


	public List<Question> getQuestionByCategory(String category) {
		// TODO Auto-generated method stub
		return questionRepo.findByCategory(category);
	}

	@Transactional
	public ResponseEntity<String> addQuestion(Question question) {
		// TODO Auto-generated method stuquestionquestion
		questionRepo.save(question);
		return new ResponseEntity( "success",HttpStatus.CREATED);
	}


	public Optional<Question> getQuestion(Integer id) {
		// TODO Auto-generated method stub
		return questionRepo.findById(id);
	}

}
