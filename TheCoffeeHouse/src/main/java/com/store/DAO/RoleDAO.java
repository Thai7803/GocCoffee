package com.store.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entity.Role;


public interface RoleDAO  extends JpaRepository<Role, String>{

	List<Role> findAll();

}
