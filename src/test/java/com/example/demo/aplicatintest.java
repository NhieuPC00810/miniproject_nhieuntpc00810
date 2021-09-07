package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Accounts;
import com.example.demo.service.AccountsService;

class aplicatintest {
	
	@Autowired
	AccountsService accountsService;
	
	@Test
	void login() {
		fail("Not yet implemented");
	}

}
