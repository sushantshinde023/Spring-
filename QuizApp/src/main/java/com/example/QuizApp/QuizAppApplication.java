package com.example.QuizApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizAppApplication.class, args);
	}

}
//Error Code: 3780. Referencing column 'quiz_id' and referenced column 'id' in foreign key constraint 'FKcgp9e1c6ww3t383aui4w8feae' are incompatible.
