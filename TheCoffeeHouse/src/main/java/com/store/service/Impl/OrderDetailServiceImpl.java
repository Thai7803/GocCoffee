package com.store.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.store.DAO.OrderDetailDAO;
import com.store.entity.OrderDetail;
import com.store.entity.Product;
import com.store.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	
	@Autowired
	OrderDetailDAO dao;

	@Override
	public OrderDetail findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public List<OrderDetail> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}


	@Override
	public OrderDetail update(OrderDetail detail) {
		// TODO Auto-generated method stub
		return dao.save(detail);
	}

	@Override
	public void delete(Long id) {
		dao.deleteById(id);
	}

	@Override
	public OrderDetail create(OrderDetail orderData) {
		// TODO Auto-generated method stub
		return dao.save(orderData);
	}



}
