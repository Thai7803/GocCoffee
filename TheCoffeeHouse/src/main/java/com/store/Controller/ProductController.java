package com.store.Controller;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.store.DAO.ProductDAO;
import com.store.entity.Product;
import com.store.service.ProductService;
import com.store.utils.SessionService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	SessionService session;
	@Autowired
	ProductDAO dao;

	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("cid") Optional<String> cid,
			@RequestParam("keywords") Optional<String> kw) {
		if (cid.isPresent()) {
			List<Product> list = productService.findByCategoryId(cid.get());
			model.addAttribute("items", list);
		} else {
			List<Product> list = productService.findAll();
			model.addAttribute("items", list);
		}
		return "product/list";
	}

	@RequestMapping("/product/search-and-page")
	public String searchAndPage(Model model, @RequestParam("keywords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		String kwords = kw.orElse(session.get("keywords"));
		session.set("keywords", kwords);
//		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		List<Product> list = dao.findByKeywords("%" + kwords + "%");
		model.addAttribute("items", list);
		return "product/list";
	}

	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		
		Product item = productService.findById(id);
		model.addAttribute("item", item);
		return "product/product-detail";
	}

	@RequestMapping("/product/search")
	public String search1(Model model, @RequestParam("min") Optional<Double> min,
			@RequestParam("max") Optional<Double> max) {
		double minPrice = min.orElse(Double.MIN_VALUE);
		double maxPrice = max.orElse(Double.MAX_VALUE);
		List<Product> list = dao.findByPriceBetween(minPrice, maxPrice);
		model.addAttribute("items", list);
		return "product/list";

	}

	@RequestMapping("/product/search2")
	public String search2(Model model, @RequestParam("min") Optional<Double> min,
			@RequestParam("max") Optional<Double> max) {
		double minPrice = min.orElse(Double.MIN_VALUE);
		double maxPrice = max.orElse(Double.MAX_VALUE);
		List<Product> list2 = dao.findByPriceBetween2(minPrice, maxPrice);
		model.addAttribute("items", list2);
		return "product/list";

	}

	@RequestMapping("/product/search4")
	public String search4(Model model, @RequestParam("min") Optional<Double> min,
			@RequestParam("max") Optional<Double> max) {
		double maxPrice = max.orElse(Double.MAX_VALUE);
		List<Product> list3 = dao.findByPrice4(maxPrice);
		model.addAttribute("items", list3);
		return "product/list";

	}

}
