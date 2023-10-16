package com.store.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.store.entity.Account;
import com.store.entity.Authority;


public interface AuthorityDAO extends JpaRepository<Authority, Integer> {

	@Query("Select distinct a from Authority a where a.account in ?1")
	List<Authority> authoritiesOf(List<Account> accounts);


}
