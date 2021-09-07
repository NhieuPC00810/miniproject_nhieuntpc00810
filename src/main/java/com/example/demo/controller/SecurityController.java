package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Accounts;
import com.example.demo.dao.AccountDAO;
import com.example.demo.service.ParamService;
import com.example.demo.service.SessionService;

@Controller
public class SecurityController {
	
	@Autowired
	ParamService paramService;
	
	@Autowired
	AccountDAO dao;
	
	@Autowired
	SessionService sessionService;
	
	@GetMapping
	public String login(RedirectAttributes param,Model model) {
		
		return "security/login";
	}
	
	@RequestMapping("/security/login/form")
	public String get(Model model) {
		model.addAttribute("message", "Vui lòng đăng nhập");
		return "security/login";
	}

	@RequestMapping("/security/login/success")
	public String success(Model model) {
		model.addAttribute("message", "Đăng nhập thành công");
		return "redirect:/product/list";
	}

	@RequestMapping("/security/login/error")
	public String error(Model model) {
		model.addAttribute("message", "Sai thông tin đăng nhập");
		return "security/login";
	}

	@RequestMapping("/security/logoff/success")
	public String logoff(Model model) {
		model.addAttribute("message", "Đăng xuất thành công");
		return "security/login";
	}
}
