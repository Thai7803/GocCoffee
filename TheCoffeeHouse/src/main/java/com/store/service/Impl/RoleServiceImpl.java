package com.store.service.Impl;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.store.DAO.RoleDAO;
import com.store.entity.Role;
import com.store.service.RoleService;




@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleDAO dao;

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
}
