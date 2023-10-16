package com.store.service.Impl;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.store.DAO.CategoryDAO;
import com.store.entity.Category;
import com.store.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDAO categoryDAO;
	@Override
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}
	@Override
	public Category create(Category category) {
		return categoryDAO.save(category);
	}

	@Override
	public Category update(Category category) {
		return categoryDAO.save(category);
	}

	@Override
	public void delete(String id) {
		categoryDAO.deleteById(id);
	}
	
	
	
}
