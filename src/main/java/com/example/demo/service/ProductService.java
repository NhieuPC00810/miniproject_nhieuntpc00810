package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Product;

public interface ProductService  {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(String id);

	Product create(Product product);

	Product update(Product product);

	void deleteById(Integer id);

}
