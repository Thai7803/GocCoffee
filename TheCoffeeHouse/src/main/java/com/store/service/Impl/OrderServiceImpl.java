package com.store.service.Impl;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.DAO.OrderDAO;
import com.store.DAO.OrderDetailDAO;
import com.store.entity.Order;
import com.store.entity.OrderDetail;
import com.store.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDAO dao;
	
	@Autowired
	OrderDetailDAO detailDAO;

	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		
		Order order = mapper.convertValue(orderData, Order.class);
		dao.save(order);
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
				.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		detailDAO.saveAll(details);
		return order;
	}

	@Override
	public Order findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<Order> findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	} 
	
	@Override
	public List<Order> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Order> findAllDESC() {
		return dao.findAllDESC();
	}

	@Override
	public void delete(Long id) {
		dao.deleteById(id);
	}

	@Override
	public Order update(Order order) {
		return dao.save(order);
	}

	
	
}
