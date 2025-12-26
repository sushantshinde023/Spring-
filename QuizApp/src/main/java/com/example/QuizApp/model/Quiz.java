package com.example.QuizApp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Quiz {
	//pk
	//title
	//questions
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
	@ManyToMany
	private List<Question> Questions;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Question> getQuestions() {
		return Questions;
	}

	public void setQuestions(List<Question> questions) {
		Questions = questions;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", Questions=" + Questions + "]";
	}
	
	
	
}
