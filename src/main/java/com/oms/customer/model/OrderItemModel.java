package com.oms.customer.model;

import java.io.Serializable;

import javax.persistence.Id;

public class OrderItemModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2497331837593287693L;
	
	@Id
	private int orderItemNo;
	private int quantity;	    
    private ProductModel productModel;
	
	
	public OrderItemModel() {}


	public OrderItemModel(int orderItemNo, int quantity, ProductModel productModel) {
		super();
		this.orderItemNo = orderItemNo;
		this.quantity = quantity;		
		this.productModel = productModel;
	}


	public int getOrderItemNo() {
		return orderItemNo;
	}


	public void setOrderItemNo(int orderItemNo) {
		this.orderItemNo = orderItemNo;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductModel getProductModel() {
		return productModel;
	}


	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}

	
}
