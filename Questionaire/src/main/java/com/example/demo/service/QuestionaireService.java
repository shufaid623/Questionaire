package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.CustomException.QuestionaireException;
import com.example.demo.model.Examinee;
import com.example.demo.model.Question;
import com.example.demo.questionaireDao.ExamineeRepository;
import com.example.demo.questionaireDao.QuestionaireRepository;

@Service
public class QuestionaireService {

	@Autowired
	public QuestionaireRepository repo;
	
	@Autowired
	public ExamineeRepository ExamineeRepo;

	public List<Question> getAllQuestions() {
		return repo.findAll();

	}

	public List<Question> getRandomQuestions(int limit) {
		return repo.findAllrandom(limit);

	}

	public String addQuestions(List<Question> questions) {

		repo.saveAll(questions);
		return "saved successfully";
	}

	public List<Question> getAllQuestionBycategory(String category) {

		List<Question> categoryresponse = repo.findByCategory(category);
		if (categoryresponse.isEmpty()) {
			throw new QuestionaireException("No Category Found for " + category);
		}
		return categoryresponse;
	}

	public Question updateAllQuestion(Question questions) {

		repo.findById(questions.getId()).orElseThrow(
				() -> new QuestionaireException(" Question Not found for update: Id " + questions.getId()));
		repo.save(questions);
		return questions;
	}

	public List<Question> getAllQuestionBydifficulty(String level) {
		List<Question> response = repo.findByDifficulty(level);
		if (response.isEmpty()) {
			throw new QuestionaireException("Sorry  Question not available for the level: " + level);
		}
		return response;
	}

	// since we have correct answer assigned to question we can validate the mark in frontend itself
	public String submitResult(Examinee examinee) {
		ExamineeRepo.save(examinee);
		long mark=examinee.getQuestion().stream().filter(ques->
			repo.findById(ques.getQuestionid()).get().getCorrectOption()==ques.getAnswerOption()).count();
		return "you got :" +mark +" points out of " +examinee.getQuestion().size();
	}

	public List<Examinee> getAllResult() {
		return ExamineeRepo.findAll();
	}

}
