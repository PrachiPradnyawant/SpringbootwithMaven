package com.dhanashri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhanashri.entity.Category;
import com.dhanashri.Service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@PostMapping("/save-category")
	public ResponseEntity<String> addCategory(@RequestBody Category category){
		Boolean isAdded = service.addCategory(category);
		if(isAdded) {
			return new ResponseEntity<String>("Saved!!",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("Not Saved!",HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/get-category-by-id/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
		Category category = service.getCategoryById(id);
		if(category!=null) {
			return new ResponseEntity<Category>(category,HttpStatus.FOUND);
		}else {
			return new ResponseEntity<Category>(category,HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/get-category-by-name")
	public ResponseEntity<Category> getCategoryByName(@RequestParam String name){
		Category category = service.getCategoryByName(name);
		if(category!=null) {
			return new ResponseEntity<Category>(category,HttpStatus.FOUND);
		}else {
			return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/get-all-category")
	public ResponseEntity<List<Category>> getAllCategory(){
		List<Category> list = service.getAllCAtegory();
		if(!list.isEmpty()) {
			return new ResponseEntity<List<Category>>(list,HttpStatus.FOUND);
		}else {
			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
		}
	}
	

}
