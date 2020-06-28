package com.app.personality.service;

import java.util.List;
import java.util.Optional;

import com.app.personality.model.Question;

public interface QuestionService {

	List<Question> findAll();

	Optional<Question> findById(Long id);

	Long findNumber();

	List<Question> findByCategoryId(Long categoryId);

	void deleteById(Long id);

}
