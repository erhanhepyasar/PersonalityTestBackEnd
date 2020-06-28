package com.app.personality.service;

import java.util.List;
import java.util.Optional;

import com.app.personality.model.Category;

public interface CategoryService {

	List<Category> findAll();

	Optional<Category> findById(Long id);

	Long findNumber();

}
