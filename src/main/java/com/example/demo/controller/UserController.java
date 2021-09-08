package com.example.demo.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.AccountDAO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.Accounts;
import com.example.demo.service.CookieService;
import com.example.demo.service.ParamService;
import com.example.demo.service.SessionService;
import com.example.demo.service.UploadService;
import com.example.demo.entity.Roles;
import com.example.demo.dao.RoleDAO;
import com.example.demo.entity.Authorities;
import com.example.demo.dao.AuthoritiesDAO;
@Controller
public class UserController {
	@Autowired
	UploadService uploadService;
	
	@Autowired
	ParamService paramService;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	ServletContext context;
	
	@Autowired
	AccountDAO usdao;
	
	@Autowired
	RoleDAO roledao;
	
	@Autowired
	AuthoritiesDAO audao;
	
	@RequestMapping("/user/index")
	public String index(Model model) {
		List<Roles> roleuser = roledao.findAll();
		model.addAttribute("roleuser", roleuser);
		Accounts item = new Accounts();
		model.addAttribute("item", item);
		List<Accounts> user = usdao.findAll();
		model.addAttribute("user", user);
		return "security/user";
	}
	
	@RequestMapping("/user/edit/{username}")
	public String edit(Model model, @PathVariable("username") String username) {
		List<Roles> roleuser = roledao.findAll();
		model.addAttribute("roleuser", roleuser);
		Accounts item = usdao.getById(username);
		model.addAttribute("username", item.getUsername());
		model.addAttribute("item", item);
		
		List<Accounts> user = usdao.findAll();
		model.addAttribute("user", user);
		return "security/user";
	}

	@RequestMapping("/user/create")
	public String create(Model model, Accounts item,RedirectAttributes param, 
			@RequestParam("username") String urn, 
			@RequestParam("fullname") String fullname, 
			@RequestParam("password") String pass, 
			@RequestParam("email") String email, 
			@RequestParam("roleid") String role) {
		Accounts kiemtra = usdao.findByid(urn);
		Roles checkrole = roledao.findByid(role);
		if(kiemtra!=null) {
			param.addAttribute("message","nhân viên đã tồn tại");
			return "redirect:/user/index";
		}else if(urn=="") {
			param.addAttribute("message","bạn chưa nhập username hãy thực hiên lại từ đầu");
			return "redirect:/user/index";
		}else if(pass=="") {
			param.addAttribute("message","bạn chưa nhập password hãy thực hiên lại từ đầu");
			return "redirect:/user/index";
		}else if(fullname=="") {
			param.addAttribute("message","bạn chưa nhập Full Name hãy thực hiên lại từ đầu");
			return "redirect:/user/index";
		}else if(email=="") {
			param.addAttribute("message","bạn chưa nhập email hãy thực hiên lại từ đầu");
			return "redirect:/user/index";
		}else if(role=="") {
			param.addAttribute("message","bạn chưa nhập Role hãy thực hiên lại từ đầu");
			return "redirect:/user/index";
		}else if(checkrole==null) {
			param.addAttribute("message","vui lòng nhập đúng chức vụ");
			return "redirect:/user/index";
		}else {
			String author=paramService.getString("roleid", "");
			List<Roles> roleuser = roledao.findAll();
			model.addAttribute("roleuser", roleuser);
			Roles items = new Roles();
			items.setId(author);
			Authorities au = new Authorities();
			au.setAccount(item);
			au.setRole(items);
			usdao.save(item);
			audao.save(au);
			return "redirect:/user/index";
		}
		
	}  

	@RequestMapping("/user/update")
	public String update(Model model, Accounts item,RedirectAttributes param, 
			@RequestParam("username") String urn, 
			@RequestParam("fullname") String fullname, 
			@RequestParam("password") String pass, 
			@RequestParam("email") String email, 
			@RequestParam("roleid") String role) {
		Accounts kiemtra = usdao.findByid(urn);
		if(kiemtra==null) {
			param.addAttribute("message","Vui lòng chọn nhân viên từ table trước khi update");
			return "redirect:/user/index";
		}else if(urn=="") {
			param.addAttribute("message","Vui lòng không để trống trường Username hãy chọn user từ table");
			return "redirect:/user/index";
		}else if(pass=="") {
			param.addAttribute("message","bạn chưa nhập password hãy thực hiên lại từ đầu");
			return "redirect:/user/index";
		}else if(fullname=="") {
			param.addAttribute("message","bạn chưa nhập Full Name hãy thực hiên lại từ đầu");
			return "redirect:/user/index";
		}else if(email=="") {
			param.addAttribute("message","bạn chưa nhập email hãy thực hiên lại từ đầu");
			return "redirect:/user/index";
		}else if(role=="") {
			param.addAttribute("message","bạn chưa nhập Role hãy thực hiên lại từ đầu");
			return "redirect:/user/index";
		}else {
			List<Roles> roleuser = roledao.findAll();
			model.addAttribute("roleuser", roleuser);
			usdao.save(item);
			return "redirect:/user/edit/" + item.getUsername(); 
		} 
	}  

	@RequestMapping("/user/delete")
	public String delete(Model model,RedirectAttributes param, 
			@RequestParam("username") String urn) {
		if(urn=="") {
			param.addAttribute("message","Vui lòng chọn User trước khi xóa");
			return "redirect:/user/index";
		}else {
		List<Roles> roleuser = roledao.findAll();
		model.addAttribute("roleuser", roleuser);
		String username1=paramService.getString("username", "");
		usdao.deleteById(username1);
		return "redirect:/user/index"; 
		} 
	} 
}
