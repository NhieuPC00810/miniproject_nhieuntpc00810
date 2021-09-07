package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Roles;

public interface RoleDAO extends JpaRepository<Roles, String>{
	@Query("SELECT o FROM Roles o WHERE  o.id=?1 ")
	Roles findByid(String id);
}
