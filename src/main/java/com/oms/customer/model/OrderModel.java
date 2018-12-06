package com.oms.customer.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class OrderModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3813042439230960023L;

	
	private int orderId;
	private int totalValue;
	private Set<OrderItemModel> orderItemModelSet = new HashSet<OrderItemModel>();
	
	
	public OrderModel() {}


	public OrderModel(int orderId, int totalValue, Set<OrderItemModel> orderItemModelSet) {
		super();
		this.orderId = orderId;
		this.totalValue = totalValue;
		this.orderItemModelSet = orderItemModelSet;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getTotalValue() {
		return totalValue;
	}


	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}


	public Set<OrderItemModel> getOrderItemModelSet() {
		return orderItemModelSet;
	}


	public void setOrderItemModelSet(Set<OrderItemModel> orderItemModelSet) {
		this.orderItemModelSet = orderItemModelSet;
	}

	
}
