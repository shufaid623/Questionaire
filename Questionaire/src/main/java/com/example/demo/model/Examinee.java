package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Examinee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="examine_id")
	private Long examineId;
	private String name;
	private String email;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="examine_id" ,referencedColumnName = "examine_id")
	private List<QuestionResult> question;
}
