package com.demo.beans;

public class Product {
	private int productId;
	private String name;
	private double price;
	private int qty;
	public Product() {
		super();
	}
	public Product(int productId, String name, double price, int qty) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", qty=" + qty + "]";
	}
	
	

}
