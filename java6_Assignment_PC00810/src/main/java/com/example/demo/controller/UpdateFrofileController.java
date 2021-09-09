package com.example.demo.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.AccountDAO;
import com.example.demo.entity.Product;
import com.example.demo.entity.Accounts;
import com.example.demo.service.CookieService;
import com.example.demo.service.ParamService;
import com.example.demo.service.SessionService;

@Controller
public class UpdateFrofileController {
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	ServletContext context;
	
	@Autowired
	AccountDAO dao;
	
	@Autowired
	CookieService cookieService;
	
	@Autowired
	ParamService paramService;
	
	@Autowired
	SessionService sessionService;
	
	
	@GetMapping("/security/updateprofile/form")
	public String suathongtin(Model model) {
		Accounts user = sessionService.get("usn");
		model.addAttribute("item",user);
		return "security/updateprofile";
	}
	
	@PostMapping("/security/updateprofile/form")
	public String suathongtin2(Accounts item,Model model,RedirectAttributes param, 
			@RequestParam("fullname") String fullname, 
			@RequestParam("email") String email) {
		Accounts user = sessionService.get("usn");
		model.addAttribute("item",user);
		if(user==null) {
			param.addAttribute("message","Vui Lòng đăng nhập");
			return "redirect:security/login";
		}else if(fullname=="") {
			param.addAttribute("message","vui lòng không bỏ trống Full Name");
			return "redirect:/security/updateprofile/form";
		}else if(email=="") {
			param.addAttribute("message","vui lòng không bỏ trống Email");
			return "redirect:/security/updateprofile/form";
		}else{
			dao.save(item);
			sessionService.set("usn", item);
			param.addAttribute("message","Sửa thành công");
			return "redirect:/security/updateprofile/form";
		}
	}
	
}
