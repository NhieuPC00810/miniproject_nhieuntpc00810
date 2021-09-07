package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Accounts;

public interface UserService  {

	List<Accounts> findAll();

	Accounts findById(String username);

	Accounts create(Accounts Account);

	Accounts update(Accounts Account);
	
	void deleteById(String username);


}
