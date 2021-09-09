package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Authorities;

public interface AuthoritesService {

	public List<Authorities> findAuthoritiesOfAdministrators();

	List<Authorities> findAll();

	Authorities save(Authorities authorities);

	void delete(Integer id);

}
