package com.store.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@SuppressWarnings("serial")
@Entity 
@Table(name = "Accounts")
public class Account implements Serializable{
	@Id
	@NotBlank(message = "Tên người dùng không được để trống")
	@Pattern(regexp = "^[a-zA-Z]",message = "Tên người dùng chỉ bao gồm chữ cái không được có dấu")
	String username;
	
	@NotBlank(message = "Mật khẩu không được để trống")
	@Size(max = 6, message = "Mật khẩu chỉ có 6 ký tự")
	String password;
	
	@NotBlank(message = "Họ và tên không được để trống")
	String fullname;
	
	@NotBlank(message = "Email không được để trống")
	@Email(message = "Địa chỉ email không hợp lệ")
	String email;
	String photo;
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<Authority> authorities;
	
	public Account() {
		super();
	}

	public Account(@NotBlank(message = "Tên người dùng không được để trống") String username,
			@Size(min = 6, message = "Mật khẩu phải có ít nhất 6 ký tự") String password,
			@NotBlank(message = "Họ và tên không được để trống") String fullname,
			@Email(message = "Địa chỉ email không hợp lệ") String email, String photo, List<Order> orders,
			List<Authority> authorities) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.photo = photo;
		this.orders = orders;
		this.authorities = authorities;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", fullname=" + fullname + ", email="
				+ email + ", photo=" + photo + ", orders=" + orders + ", authorities=" + authorities + "]";
	}
	
	
}
