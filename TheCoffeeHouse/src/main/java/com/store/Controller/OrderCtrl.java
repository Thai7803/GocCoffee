package com.store.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.store.DAO.OrderDAO;
import com.store.entity.Comment;
import com.store.entity.Order;
import com.store.service.OrderService;


@Controller
public class OrderCtrl {
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderDAO dao;
	
	
	@RequestMapping("/order/checkout")
	public String checkout() {
		return "order/checkout";
	}

	@RequestMapping("/order/list")
	public String list( Model model, HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("orders", orderService.findByUsername(username));
		return "order/list";
	}
//	
	@RequestMapping("/order/detail/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("order", orderService.findById(id));
		return "order/detail";
	}
	
	@RequestMapping("/order/cancel/{id}") // Huỷ đơn hàng
    public String cancel(@PathVariable("id") Long id) {
        Order order = orderService.findById(id);
        order.setAction("Đã huỷ xác nhận");
        dao.save(order);
        return "redirect:/order/list";
    }

    @RequestMapping("/order/receive/{id}") // Đã nhận được hàng
    public String receive(@PathVariable("id") Long id, Model model, Order order) {
        order = orderService.findById(id);
        dao.save(order);

        // Thêm thông tin cần thiết vào model, ví dụ: orderID
        model.addAttribute("orderId", id);

        // Chuyển hướng đến trang đánh giá sản phẩm
        return "product/review";
    }
    


}
