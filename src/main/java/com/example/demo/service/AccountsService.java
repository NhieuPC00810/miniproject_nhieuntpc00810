package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Accounts;

public interface AccountsService {
	Accounts findById(String id);

	List<Accounts> findAll();

	List<Accounts> getAdmin();
	
	
	
}
