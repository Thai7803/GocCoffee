package com.store.rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.DAO.OrderDetailDAO;
import com.store.entity.TopProduct;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/topproduct")
public class TopProductRestController {
	
	@Autowired
	OrderDetailDAO orderDetailDAO;

	@GetMapping()
	public List<TopProduct> getAll() {
		return orderDetailDAO.getTop10();
	}
	
}
