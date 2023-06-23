package com.dhanashri.ServiceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhanashri.Dao.CategoryDao;
import com.dhanashri.entity.Category;
import com.dhanashri.Service.CategoryService;

@Service
public class CategoryServiceIMPL implements CategoryService{
	
	@Autowired
	private CategoryDao dao;

	@Override
	public Boolean addCategory(Category category) {
		
		return dao.addCategory(category);
	}

	@Override
	public Category getCategoryById(Long id) {
		return dao.getCategoryById(id);
	}

	@Override
	public Category getCategoryByName(String name) {
		return dao.getCategoryByName(name);
	}

	@Override
	public List<Category> getAllCAtegory() {
		return dao.getAllCAtegory();
	}

}
