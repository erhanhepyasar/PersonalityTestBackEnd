package com.app.personality.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.personality.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
