package com.example.demo.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Accounts;
import com.example.demo.service.AccountsService;

@CrossOrigin("*")	
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
	@Autowired
	AccountsService service;

	@GetMapping()
	public List<Accounts> getAccounts(@RequestParam("admins") Optional<Boolean> admin) {
		if (admin.orElse(false)) {
			return service.getAdmin();
		}
		return service.findAll();
	}
}
