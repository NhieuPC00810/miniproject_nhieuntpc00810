package com.example.demo.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.AccountDAO;
import com.example.demo.entity.Accounts;
import com.example.demo.service.CookieService;
import com.example.demo.service.ParamService;
import com.example.demo.service.SessionService;

@Controller
public class ChangePassController {
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
	
	
	@GetMapping("/security/chanepass/form")
	public String suathongtin(Model model) {
		Accounts user = sessionService.get("usn");
		model.addAttribute("items",user);
		return "security/changepass";
	}
	
	@PostMapping("/security/chanepass/form")
	public String suathongtin2(Accounts item,Model model,RedirectAttributes param,
			@RequestParam("currentpassword") String currentpass,
			@RequestParam("password") String newpass, 
			@RequestParam("confirmpassword") String confirm) {
		Accounts user = sessionService.get("usn");
		model.addAttribute("items",user);
		if(user==null) {
			param.addAttribute("message","Vui Lòng đăng nhập");
			return "redirect:security/login";
		}else if(currentpass=="") {
			param.addAttribute("message","vui lòng không bỏ trống Current PassWord");
			return "redirect:/security/chanepass/form";
		}else if(newpass=="") {
			param.addAttribute("message","vui lòng không bỏ trống New PassWord");
			return "redirect:/security/chanepass/form";
		}else if(confirm=="") {
			param.addAttribute("message","vui lòng không bỏ trống Confirm PassWord");
			return "redirect:/security/chanepass/form";
		}else  {
			if((currentpass.equals(user.getPassword()))&&(newpass.equals(confirm))){
				dao.save(item);
				sessionService.set("usn", item);
				param.addAttribute("message","Đổi Mật Khẩu thành công");
				return "redirect:/security/chanepass/form";
			}else if(!newpass.equals(confirm)) {
				param.addAttribute("message","Xác Nhận Mật khẩu và Mật khẩu không trùng khớp");
				return "redirect:/security/chanepass/form";
			}else if(!currentpass.equals(user.getPassword())) {
				param.addAttribute("message","Mật khẩu cũ không chính xác");
				return "redirect:/security/chanepass/form";
			} 
			return "security/changepass";
		}
	}
	
}
