package com.store.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;


@Entity 
@Table(name = "Comments")
public class Comment implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String content;
	String image;
	private Integer rate;
	
	@ManyToOne
	@JoinColumn(name = "Username")
	Account account;

	
	@ManyToOne
	@JoinColumn(name = "Productid")
	Product product;
	@Column(name = "Createdate")
	String createDate;
	
	private boolean active = true;
	public Comment() {
		super();
	}


public Comment(Integer id, String content, String image, Integer rate, Account account, Product product,
			String createDate, boolean active) {
		super();
		this.id = id;
		this.content = content;
		this.image = image;
		this.rate = rate;
		this.account = account;
		this.product = product;
		this.createDate = createDate;
		this.active = active;
	}


	public String getCreateDate() {
	return createDate;
}


public void setCreateDate(String createDate) {
	this.createDate = createDate;
}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
