package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CategoryDAO;
import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDAO dao;

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
