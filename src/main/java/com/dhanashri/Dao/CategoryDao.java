package com.dhanashri.Dao;

import java.util.List;

import com.dhanashri.entity.Category;

public interface CategoryDao {

	public Boolean addCategory(Category category);
	public Category getCategoryById(Long id);
	public Category getCategoryByName(String name);
	public List<Category> getAllCAtegory();

}
