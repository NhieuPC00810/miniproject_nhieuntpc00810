package com.example.demo.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.AccountDAO;
import com.example.demo.dao.AuthoritiesDAO;
import com.example.demo.entity.Accounts;
import com.example.demo.entity.Roles;
import com.example.demo.entity.Authorities;
import com.example.demo.service.ParamService;

@Controller
public class SigupController {
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	ServletContext context;
	
	@Autowired
	AccountDAO dao;
	
	@Autowired
	AuthoritiesDAO audao;
	
	@Autowired
	ParamService paramService;

	@GetMapping("/security/registration/form")
	public String dangky(Model model) {
		Accounts item = new Accounts();
		Roles items = new Roles();
		model.addAttribute("item", item);
		return "security/registration";
	}
	
	@PostMapping("/security/registration/form")
	public String dangky2(Accounts item,Roles items ,RedirectAttributes param, 
			@RequestParam("username") String urn, 
			@RequestParam("fullname") String fullname, 
			@RequestParam("password") String pass, 
			@RequestParam("email") String email) {
		items.setId("CUST");
		Authorities au = new Authorities();
		au.setAccount(item);
		au.setRole(items);
		Accounts kiemtra = dao.findByid(urn);
		if(kiemtra!=null) {
			param.addAttribute("message","Tài Khoản đã tồn tại");
			return "redirect:/security/registration/form";
		}else  if(urn=="") {
			param.addAttribute("message","bạn chưa nhập username hãy thực hiên lại từ đầu");
			return "redirect:/security/registration/form";
		}else if(pass=="") {
			param.addAttribute("message","bạn chưa nhập password hãy thực hiên lại từ đầu");
			return "redirect:/security/registration/form";
		}else if(fullname=="") {
			param.addAttribute("message","bạn chưa nhập Full Name hãy thực hiên lại từ đầu");
			return "redirect:/security/registration/form";
		}else if(email=="") {
			param.addAttribute("message","bạn chưa nhập email hãy thực hiên lại từ đầu");
			return "redirect:/security/registration/form";
		}else {
			dao.save(item);
			audao.save(au);
			param.addAttribute("message","Đăng ký thành công");
			return "redirect:/security/registration/form";
		}

	}
}
