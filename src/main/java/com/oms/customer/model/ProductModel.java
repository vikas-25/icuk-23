package com.oms.customer.model;

import java.io.Serializable;

public class ProductModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1266239417218067644L;
	
	private int productId;
	private String name;
	private String type;
	private int price;
		
	public ProductModel() {}

	public ProductModel(int productId, String name, String type, int price) {
		super();
		this.productId = productId;
		this.name = name;
		this.type = type;
		this.price = price;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
