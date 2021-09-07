package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {
	@RequestMapping("/security/registration/form")
	public String get(Model model) {
		model.addAttribute("message", "Vui lòng đăng nhập");
		return "security/registration";
	}

	@RequestMapping("/security/registration/success")
	public String success(Model model) {
		model.addAttribute("message", "Đăng nhập thành công");
		return "security/registration";
	}
 
	@RequestMapping("/security/registration/error")
	public String error(Model model) {
		model.addAttribute("message", "Sai thông tin đăng nhập");
		return "security/registration";
	}


}
