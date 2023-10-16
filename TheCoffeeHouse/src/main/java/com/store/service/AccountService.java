package com.store.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import com.store.entity.Account;


public interface AccountService {

	public Account findById(String username);

	public List<Account> getAdministrators();

	public List<Account> findAll();
	
	public Account create(Account account);

	public Account update(Account account);

	public void delete(String username);

//	public void loginFromOAuth2(OAuth2AuthenticationToken oauth2);
}
