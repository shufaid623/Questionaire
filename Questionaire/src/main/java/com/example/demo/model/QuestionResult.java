package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class QuestionResult {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long resultId;
	@Column(name="examine_id")
	private Long examineId;
	private long questionid;
	private int answerOption;

}
