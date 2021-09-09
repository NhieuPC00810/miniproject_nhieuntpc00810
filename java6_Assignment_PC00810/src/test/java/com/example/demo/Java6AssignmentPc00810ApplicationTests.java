package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;

import com.example.demo.controller.SigupController;
import com.example.demo.controller.UpdateFrofileController;
import com.example.demo.entity.Accounts;
import com.example.demo.entity.Roles;
import com.example.demo.service.SessionService;
import com.example.demo.dao.AccountDAO;
@SpringBootTest
class Java6AssignmentPc00810ApplicationTests {

	@Autowired
	SigupController  sigupController; 
	
	@Autowired
	UpdateFrofileController  updateFrofileController; 
	
	@Autowired
	SessionService sessionService;
	
	@Test
	void login(RedirectAttributes param) {
		param.addAttribute("message","Đăng ký thành công");
		Roles Role = new Roles();
		Role.setId("CUST");
		Accounts test = new Accounts();
		test.setUsername("nguyenthanhnhieu");
		test.setPassword("123");
		test.setFullname("nguyenthanhnhieu");
		test.setEmail("nhieu@gmail.com");
		test.setPhoto("photo.gif");
		
		sigupController.dangky2(test, Role,param, "nguyenthanhnhieu", "123", "nguyenthanhnhieu", "nhieu@gmail.com");
		
	}
	
	@Test
	void update(RedirectAttributes param,Model model) {
		Accounts user = sessionService.get("usn");
		model.addAttribute("item",user);
		param.addAttribute("message","Đăng ký thành công");
		Roles Role = new Roles();
		Role.setId("CUST");
		Accounts test = new Accounts();
		test.setUsername("nguyenthanhnhieu");
		test.setPassword("123");
		test.setFullname("nguyenthanhnhieu");
		test.setEmail("nhieu@gmail.com");
		test.setPhoto("photo.gif");
		updateFrofileController.suathongtin2(test, model, param, "thanh nhieu", "nhieu@gmail.com");
	}

}
