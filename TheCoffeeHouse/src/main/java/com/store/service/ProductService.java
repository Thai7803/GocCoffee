package com.store.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.store.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(String string);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);

	Page<Product> findAll(Pageable pageable);

}
