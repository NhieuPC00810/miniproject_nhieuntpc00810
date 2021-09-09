package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping("/order/checkout")
	public String checkout() {
		System.out.println("asdasdadss");
		return "order/checkout";
	}

	@RequestMapping("/order/list")
	public String list(Model model,HttpServletRequest request) {
		String username = request.getRemoteUser(); // lấy ra username nhớ Spring security đã lưu lên User trc đó
		model.addAttribute("orders",orderService.findByUsername(username));
		return "order/list";
	}

	@RequestMapping("/order/detail/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("order",orderService.findById(id));
		return "order/detail";
	}

}
