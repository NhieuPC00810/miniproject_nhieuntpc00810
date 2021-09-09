package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Accounts;


public interface AccountDAO extends JpaRepository<Accounts, String> {

	@Query("SELECT o FROM Accounts o WHERE  o.username=?1 ")
	Accounts findByid(String id);
	
	@Query("SELECT DISTINCT ar.account FROM Authorities ar WHERE ar.role.id IN ('DIRE', 'STAF')")
	// lấy ra những account có vai trò DIRE và STAFF
	List<Accounts> findAdmin();

}
