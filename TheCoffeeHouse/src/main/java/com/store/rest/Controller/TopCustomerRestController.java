package com.store.rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.DAO.AccountDAO;
import com.store.entity.TopCustomer;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/topcustomer")
public class TopCustomerRestController {
	
	@Autowired
	AccountDAO accountDAO;
	
	@GetMapping()
	public List<TopCustomer> getAll() {
		return accountDAO.getTopAccount();
	}
//	
}
