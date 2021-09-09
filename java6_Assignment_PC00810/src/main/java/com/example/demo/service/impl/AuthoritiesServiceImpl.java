package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountDAO;
import com.example.demo.dao.AuthoritiesDAO;
import com.example.demo.entity.Accounts;
import com.example.demo.entity.Authorities;
import com.example.demo.service.AuthoritesService;

@Service
public class AuthoritiesServiceImpl implements AuthoritesService {
	@Autowired
	AccountDAO dAccountDAO;
	@Autowired
	AuthoritiesDAO dao;

	public List<Authorities> findAuthoritiesOfAdministrators() {
		List<Accounts> accounts = dAccountDAO.findAdmin();
		System.out.println(dao.authoritiesOf(accounts));
		return dao.authoritiesOf(accounts);
	}

	@Override
	public List<Authorities> findAll() {
		return dao.findAll();
	}

	@Override
	public Authorities save(Authorities authorities) {
		return dao.save(authorities);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);

	}

}
