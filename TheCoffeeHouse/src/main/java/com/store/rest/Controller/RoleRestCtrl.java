package com.store.rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.entity.Role;
import com.store.service.RoleService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
public class RoleRestCtrl {
	@Autowired
	RoleService roleService;
	
	
	@GetMapping()
	public List<Role> getAll() {
		return roleService.findAll();
	}
	
}
