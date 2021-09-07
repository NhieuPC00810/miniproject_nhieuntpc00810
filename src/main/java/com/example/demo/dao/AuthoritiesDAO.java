package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Accounts;
import com.example.demo.entity.Authorities;


public interface AuthoritiesDAO extends JpaRepository<Authorities, Integer> {
	
	
	@Query("SELECT DISTINCT a FROM Authorities a WHERE a.account IN ?1")
	List<Authorities> authoritiesOf(List<Accounts> accounts);

}
