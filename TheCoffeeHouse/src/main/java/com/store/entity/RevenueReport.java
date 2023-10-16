package com.store.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

 
@Entity
public class RevenueReport implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	Category category;
	double revenue;
	long count;
	
	
	public RevenueReport() {
		super();
	}
	public RevenueReport(Category category, double revenue, long count) {
		super();
		this.category = category;
		this.revenue = revenue;
		this.count = count;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}	
