package com.example.demo.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Accounts;
import com.example.demo.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/users")
public class UserRestController {

	@Autowired
	UserService accountsService;

	@GetMapping("{username}")
	public Accounts getOne(@PathVariable("username") String username) {
		return accountsService.findById(username);
	}

	@GetMapping()
	public List<Accounts> getList() {
		return accountsService.findAll();
	}

	@PostMapping()
	public Accounts save(@RequestBody Accounts Account) {
		return accountsService.create(Account);
	}

	@PutMapping("{username}")
	public Accounts put(@PathVariable("username") String username, @RequestBody Accounts Account) {
		return accountsService.update(Account);
	}

	@DeleteMapping("{username}")
	public void delete(@PathVariable("username") String username) {
		accountsService.deleteById(username);
	}
}
