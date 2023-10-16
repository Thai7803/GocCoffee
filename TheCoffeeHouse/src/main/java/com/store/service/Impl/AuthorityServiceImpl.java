package com.store.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.DAO.AccountDAO;
import com.store.DAO.AuthorityDAO;
import com.store.entity.Account;
import com.store.entity.Authority;
import com.store.service.AuthorityService;


@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired
	AuthorityDAO dao;
	
	@Autowired
	AccountDAO accountDAO;

	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts = accountDAO.getAministrators();
		return dao.authoritiesOf(accounts);
	}

	public Authority create(Authority auth) {
		return dao.save(auth);
	}
	
	public void delete(Integer id) {
		dao.deleteById(id);
	}
	
	public List<Authority> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	

	

}
