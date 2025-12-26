package com.example.QuizApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.QuizApp.dao.QuestionRepository;
import com.example.QuizApp.dao.QuizDao;
import com.example.QuizApp.model.Question;
import com.example.QuizApp.model.QuestionWrapper;
import com.example.QuizApp.model.Quiz;
import com.example.QuizApp.model.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionRepository questionDao;

	public ResponseEntity<String> createQuiz(String category, Integer noOfQuestion, String title) {
		// TODO Auto-generated method stub
		List<Question> questions=questionDao.findRandomQuestionsByCategory(category,noOfQuestion);
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);

		return new ResponseEntity("success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer quizId) {
		// TODO Auto-generated method stub
		
		Optional<Quiz> quiz=quizDao.findById(quizId);
		List<Question> questionsFromDB=quiz.get().getQuestions();
		List<QuestionWrapper> questionForUser=new ArrayList<>();
		for(Question q: questionsFromDB) {
			QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionForUser.add(qw);
		}
		return new ResponseEntity<List<QuestionWrapper>>(questionForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer quizId, List<Response> responses) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz=quizDao.findById(quizId);
		List<Question> questionsFromDB=quiz.get().getQuestions();
		int right =0;
		int i=0;
		for(Response response:responses) {
			if(response.getResponse().equals(questionsFromDB.get(i).getRightAnswer()))
				right++;
			
			i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
	
	

}
