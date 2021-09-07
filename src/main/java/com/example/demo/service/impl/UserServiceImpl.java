package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountDAO;
import com.example.demo.entity.Accounts;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
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
	public Accounts create(Accounts Account) {
		// TODO Auto-generated method stub
		return dao.save(Account);
	}

	@Override
	public Accounts update(Accounts Account) {
		// TODO Auto-generated method stub
		return dao.save(Account);
	}

	@Override
	public void deleteById(String username) {
		// TODO Auto-generated method stub
		dao.deleteById(username);
	}

}
