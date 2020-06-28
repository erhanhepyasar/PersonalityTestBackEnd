package com.app.personality.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.personality.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

	List<Question> findByCategoryId(Long categoryId);

}
