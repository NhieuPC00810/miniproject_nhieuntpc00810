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
public class RoleController {
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
	
	@RequestMapping("/role/index")
	public String index(Model model) {
		Roles item = new Roles();
		model.addAttribute("item", item);
		List<Roles> role = roledao.findAll();
		model.addAttribute("role", role);
		return "security/role";
	}
	
	@RequestMapping("/role/edit/{id}")
	public String edit(Model model, @PathVariable("id") String id) {
		Roles item = roledao.getById(id);
		model.addAttribute("id", item.getId());
		model.addAttribute("item", item);
		
		List<Roles> role = roledao.findAll();
		model.addAttribute("role", role);
		return "security/role";
	}

	@RequestMapping("/role/create")
	public String create(Model model, Roles item,RedirectAttributes param, 
			@RequestParam("id") String id, 
			@RequestParam("name") String name) {
		Roles kiemtra = roledao.findByid(id);
		if(kiemtra!=null) {
			param.addAttribute("message","Chức vụ đã tồn tại");
			return "redirect:/role/index";
		}else if(id=="") {
			param.addAttribute("message","bạn chưa nhập Role ID hãy thực hiên lại từ đầu");
			return "redirect:/role/index";
		}else if(name=="") {
			param.addAttribute("message","bạn chưa nhập Role Name hãy thực hiên lại từ đầu");
			return "redirect:/role/index";
		}else {
			roledao.save(item);
			param.addAttribute("message","Tạo chức vụ thành công");
			return "redirect:/role/index";
		}  
	}  

	@RequestMapping("/role/update")
	public String update(Model model, Roles item,RedirectAttributes param, 
			@RequestParam("id") String id, 
			@RequestParam("name") String name) {
		Roles kiemtra = roledao.findByid(id);
		if(kiemtra==null) {
			param.addAttribute("message","Vui lòng chọn chức vụ từ table trước khi update");
			return "redirect:/role/index";
		}else if(id=="") {
			param.addAttribute("message","bạn chưa nhập Role ID hãy thực hiên lại từ đầu");
			return "redirect:/role/index";
		}else if(name=="") {
			param.addAttribute("message","bạn chưa nhập Role Name hãy thực hiên lại từ đầu");
			return "redirect:/role/index";
		}else {
			roledao.save(item);
			return "redirect:/role/edit/" + item.getId();  
		}
	}  

	@RequestMapping("/role/delete")
	public String delete(Model model) {
		String id=paramService.getString("id", "");
		usdao.deleteById(id);
		return "redirect:/role/index"; 
	}
}
