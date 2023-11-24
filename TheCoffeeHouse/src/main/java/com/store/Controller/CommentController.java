package com.store.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.entity.Account;
import com.store.entity.Comment;
import com.store.entity.Order;
import com.store.entity.OrderDetail;
import com.store.entity.Product;
import com.store.service.AccountService;
import com.store.service.CommentService;
import com.store.service.OrderDetailService;
import com.store.service.OrderService;
import com.store.service.ProductService;


@Controller
public class CommentController {

	@Autowired
	AccountService accountService;
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	ProductService productService;
	@RequestMapping("/product/review")
	public String review(Model model, Comment comment ) {
		comment = commentService.create(comment);
		model.addAttribute("message", "Thank you for your purchase!");
		return "product/review";
	}
}
