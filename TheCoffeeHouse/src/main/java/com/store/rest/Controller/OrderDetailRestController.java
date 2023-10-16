package com.store.rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.store.entity.Order;
import com.store.entity.OrderDetail;
import com.store.entity.Product;
import com.store.service.OrderDetailService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orderdetails")
public class OrderDetailRestController {
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@GetMapping()
	public List<OrderDetail> getAll() {
		return orderDetailService.findAll();
	}
	@PostMapping()
	public OrderDetail create (@RequestBody OrderDetail orderData) {
		return orderDetailService.create(orderData);
	}
	
	
	@GetMapping("{id}")
	public OrderDetail getOne(@PathVariable("id") Long id) {
		return orderDetailService.findById(id);
	}

//	
////	
	@PutMapping("{id}")
	public OrderDetail update(@PathVariable("id") Long id, @RequestBody OrderDetail detail) {
		return orderDetailService.update(detail);
	}
//	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		 orderDetailService.delete(id);
	}
//
//	
	
}
