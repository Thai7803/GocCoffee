package com.store.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class TopProduct implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	Product product;
	long sum;
	
	
	public TopProduct() {
		super();
	}
	public TopProduct(Product product, long sum) {
		super();
		this.product = product;
		this.sum = sum;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public long getSum() {
		return sum;
	}
	public void setSum(long sum) {
		this.sum = sum;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
