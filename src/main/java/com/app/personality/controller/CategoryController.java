package com.app.personality.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.personality.model.Category;
import com.app.personality.service.CategoryService;
import com.app.personality.util.ApiPaths;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(ApiPaths.CategoryCtrl.CTRL)
@Api(value = ApiPaths.CategoryCtrl.CTRL)
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	@ApiOperation(value = "Find All Categories", response = Category.class, responseContainer = "List")
	public ResponseEntity<List<Category>> findAll() {
		return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/number")
	@ApiOperation(value = "Find Number", response = Category.class, responseContainer = "List")
	public ResponseEntity<String> findNumber() {
		Long number = categoryService.findNumber();
		// I converted number to String, because long is not a suitable response for rest api
		return new ResponseEntity<>(number.toString(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Find By Id", response = Category.class)
	public ResponseEntity<Optional<Category>> findById(@PathVariable(value = "id", required = true) Long id) {
		return ResponseEntity.ok(categoryService.findById(id));
	}

}
