package com.store.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.store.entity.OrderDetail;
import com.store.entity.Product;

public interface OrderDetailService {
	
	public OrderDetail findById(Long id);

	public List<OrderDetail> findAll();
	public OrderDetail update(OrderDetail detail);

	void delete(Long id);


	public OrderDetail create(OrderDetail orderData);
}
