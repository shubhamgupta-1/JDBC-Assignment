package com.ymsli.mvc.model.persistance.product;

import java.sql.Date;

public class Product {
	private int id;
	private String name;
	private double price;
	private int qty;
	private Date mfd;
	private Date inspDate;
	public Product(String name, double price, int qty, Date mfd, Date inspDate) {
		super();
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.mfd = mfd;
		this.inspDate = inspDate;
	}
	public Product(int id, String name, double price, int qty, Date mfd, Date inspDate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.mfd = mfd;
		this.inspDate = inspDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Date getMfd() {
		return mfd;
	}
	public void setMfd(Date mfd) {
		this.mfd = mfd;
	}
	public Date getInspDate() {
		return inspDate;
	}
	public void setInspDate(Date inspDate) {
		this.inspDate = inspDate;
	}
	

}
