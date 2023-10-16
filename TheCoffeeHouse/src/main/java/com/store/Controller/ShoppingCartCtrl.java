package com.store.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.store.DAO.OrderDAO;
import com.store.DAO.ProductDAO;

@Controller
@CrossOrigin
public class ShoppingCartCtrl {
	
	@RequestMapping("/cart/view")
	public String view() {
		return "cart/view";
	}
	
}
