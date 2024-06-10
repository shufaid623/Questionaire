package com.example.demo.questionaireDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Examinee;

@Repository
public interface ExamineeRepository extends JpaRepository<Examinee,Long> {

}
