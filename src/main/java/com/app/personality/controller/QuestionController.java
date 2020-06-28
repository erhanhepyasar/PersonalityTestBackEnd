package com.app.personality.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.personality.model.Question;
import com.app.personality.service.QuestionService;
import com.app.personality.util.ApiPaths;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(ApiPaths.QuestionCtrl.CTRL)
@Api(value = ApiPaths.QuestionCtrl.CTRL)
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@GetMapping
	@ApiOperation(value = "Find All Questions", response = Question.class, responseContainer = "List")
	public ResponseEntity<List<Question>> findAll() {
		return new ResponseEntity<>(questionService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/number")
	@ApiOperation(value = "Find Number", response = Question.class, responseContainer = "List")
	public ResponseEntity<String> findNumber() {
		Long number = questionService.findNumber();
		// I converted number to String, because long is not a suitable response for rest api
		String strNumber = number.toString();
		return new ResponseEntity<>(strNumber, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Find By Id", response = Question.class)
	public ResponseEntity<Optional<Question>> findById(@PathVariable(value = "id", required = true) Long id) {
		return ResponseEntity.ok(questionService.findById(id));
	}

	@GetMapping("/category/{id}")
	@ApiOperation(value = "Find By Category Id", response = Question.class)
	public ResponseEntity<List<Question>> findByCategoryId(
			@PathVariable(value = "id", required = true) Long categoryId) {
		return new ResponseEntity<>(questionService.findByCategoryId(categoryId), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete By Id", response = Question.class)
	public ResponseEntity<Optional<Question>> deleteById(@PathVariable(value = "id", required = true) Long id) {
		Optional<Question> question = questionService.findById(id);
		questionService.deleteById(id);
		return ResponseEntity.ok(question);
	}

}
