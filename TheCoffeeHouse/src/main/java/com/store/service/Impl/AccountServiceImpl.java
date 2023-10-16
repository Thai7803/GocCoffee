package com.store.service.Impl;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.store.DAO.AccountDAO;
import com.store.entity.Account;
import com.store.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountDAO dao; 

//	@Autowired
//	BCryptPasswordEncoder pe;

	@Override
	public Account findById(String username) {
		// TODO Auto-generated method stub
		return dao.findById(username).get();
	}

	@Override
	public List<Account> getAdministrators() {
		// TODO Auto-generated method stub
		return dao.getAministrators();
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Account create(Account account) {
		return dao.save(account);
	}

	@Override
	public Account update(Account account) {
		return dao.save(account);
	}

	@Override
	public void delete(String username) {
		dao.deleteById(username);
	}



//	public void loginFromOAuth2(OAuth2AuthenticationToken oauth2) {
//		String fullname = oauth2.getPrincipal().getAttribute("name");
//		String email = oauth2.getPrincipal().getAttribute("email");
//		String password = Long.toHexString(System.currentTimeMillis()); // mk ngẫu nhiên
//
//		UserDetails user = User.withUsername(email).password(pe.encode(password)).roles("CUST").build();
//		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//		SecurityContextHolder.getContext().setAuthentication(auth);
//	}

	
}
