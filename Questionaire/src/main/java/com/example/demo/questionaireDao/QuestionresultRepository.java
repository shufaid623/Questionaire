package com.example.demo.questionaireDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Examinee;
import com.example.demo.model.QuestionResult;

@Repository
public interface QuestionresultRepository extends JpaRepository<QuestionResult,Long>  {

}
