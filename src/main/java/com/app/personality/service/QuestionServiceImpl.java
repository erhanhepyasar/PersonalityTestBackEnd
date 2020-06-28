package com.app.personality.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.personality.model.Question;
import com.app.personality.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public List<Question> findAll() {
		return questionRepository.findAll();
	}

	@Override
	public Long findNumber() {
		return questionRepository.count();
	}

	@Override
	public Optional<Question> findById(Long id) {
		return questionRepository.findById(id);
	}

	@Override
	public List<Question> findByCategoryId(Long categoryId) {
		return questionRepository.findByCategoryId(categoryId);
	}

	@Override
	public void deleteById(Long id) {
		questionRepository.deleteById(id);
	}

}
