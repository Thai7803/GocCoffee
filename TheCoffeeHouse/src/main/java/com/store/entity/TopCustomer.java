package com.store.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class TopCustomer {
	@Id
	Account account;
	long count;
	
	
	public TopCustomer() {
		super();
	}
	public TopCustomer(Account account, long count) {
		super();
		this.account = account;
		this.count = count;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
	
}	
