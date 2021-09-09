package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.AccountDAO;
import com.example.demo.entity.Accounts;
import com.example.demo.service.AccountsService;

@Service
public class AccountServiceImpl implements AccountsService {
	@Autowired
	AccountDAO dao;

	@Override
	public Accounts findById(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<Accounts> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Accounts> getAdmin() {
		// TODO Auto-generated method stub
		return dao.findAdmin();
	}

}
