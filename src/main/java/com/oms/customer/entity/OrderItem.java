package com.oms.customer.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "orderitem")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2497331837593287693L;
	
	@Id
	private int orderItemNo;
	private int quantity;
		
	@JsonBackReference(value="order-item")
	@ManyToOne(optional = false)
    @JoinColumn(name = "order_id")	
    private Order order;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
    private Product product;
	
	
	public OrderItem() {}


	public OrderItem(int orderItemNo, int quantity,  Order order, Product product) {
		super();
		this.orderItemNo = orderItemNo;
		this.quantity = quantity;		
		this.order = order;
		this.product = product;
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


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	
}
