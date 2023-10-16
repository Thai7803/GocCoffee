package com.store.service;

import java.util.List;

import com.store.entity.Category;

public interface CategoryService {

	List<Category> findAll();


	Category create(Category category);

	Category update(Category category);

	void delete(String id);
}
