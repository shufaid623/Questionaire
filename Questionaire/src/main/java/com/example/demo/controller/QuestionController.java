package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Examinee;
import com.example.demo.model.Question;
import com.example.demo.service.QuestionaireService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	QuestionaireService questionaireService;

	// Get All availaable question
	@GetMapping("allquestions")
	public List<Question> getAllQuestion() {

		return questionaireService.getAllQuestions();
	}

	// Get limited number of random question from all question. Number of questions passed through url
	@GetMapping("allquestions/random/{questions}")
	public List<Question> getRandomQuestion(@PathVariable("questions") int questions) {

		return questionaireService.getRandomQuestions(questions);
	}

	// Add new Question to the database
	@PostMapping("addquestions")
	public String addQuestion(@RequestBody List<Question> questions) {

		return questionaireService.addQuestions(questions);
	}

	// Get All question based on category
	@GetMapping("allquestions/{category}")
	public List<Question> getAllQuestionBycategory(@PathVariable("category") String category) {
		return questionaireService.getAllQuestionBycategory(category);
	}

	// update an available question
	@PutMapping("addquestions")
	public Question updateQuestion(@RequestBody Question questions) {
		return questionaireService.updateAllQuestion(questions);
	}

	// Get All question based on difficulty
	@GetMapping("allquestions/difficulty/{level}")
	public List<Question> getAllQuestionBydifficulty(@PathVariable("level") String level) {
		return questionaireService.getAllQuestionBydifficulty(level);
	}
	
	@PostMapping("allquestions/submit")
	public String getAllQuestionBydifficulty(@RequestBody Examinee examinee) {
		return questionaireService.submitResult(examinee);
	}
	
	@GetMapping("allquestions/result")
	public List<Examinee> getAllResult() {
		return questionaireService.getAllResult();
	}

}
