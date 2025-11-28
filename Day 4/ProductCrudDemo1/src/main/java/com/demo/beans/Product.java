package com.demo.beans;

import java.time.LocalDate;

public class Product {
	private int id;
	private String name;
	private Double price;
	private int qty;
	private LocalDate expdate;
	private int cid;
	public Product() {
		super();
	}
	public Product(int id, String name, Double price, int qty, LocalDate expdate, int cid) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.expdate = expdate;
		this.cid = cid;
	}
	
	
	public Product(String name, Double price, int qty, LocalDate expdate, int cid) {
		super();
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.expdate = expdate;
		this.cid = cid;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public LocalDate getExpdate() {
		return expdate;
	}
	public void setExpdate(LocalDate expdate) {
		this.expdate = expdate;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", qty=" + qty + ", expdate=" + expdate
				+ ", cid=" + cid + "]";
	}
	
	
	
}
