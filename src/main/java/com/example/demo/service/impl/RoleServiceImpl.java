package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RoleDAO;
import com.example.demo.entity.Roles;
import com.example.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDAO dao;
	
	@Override
	public List<Roles> findAll() {
		return dao.findAll();
	}

}
