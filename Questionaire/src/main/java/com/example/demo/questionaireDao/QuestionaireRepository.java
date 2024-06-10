package com.example.demo.questionaireDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Question;

@Repository
public interface QuestionaireRepository  extends JpaRepository<Question,Long>{

	public List<Question> findByCategory(String category);

	public List<Question> findByDifficulty(String level);

	@Modifying
	@Query(value="SELECT * FROM question ORDER BY RANDOM() LIMIT :limit",nativeQuery = true)
	public List<Question> findAllrandom(@Param("limit") int limit);


}
