package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String questionTitle;
	private String description;
	private String category;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;
	private Integer correctOption;
	private String difficulty;
	private String hint;
}
