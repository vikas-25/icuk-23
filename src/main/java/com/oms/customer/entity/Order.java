package com.oms.customer.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3813042439230960023L;

	@Id
	private int orderId;
	private int totalValue;
	
	//@JsonBackReference(value="customer-order")
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;
	
	@JsonManagedReference(value="order-item")
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrderItem> orderItemSet = new HashSet<OrderItem>();
	
	
	
	public Order() {}

	
	public Order(int orderId, int totalValue, Customer customer, Set<OrderItem> orderItemSet) {
		super();
		this.orderId = orderId;
		this.totalValue = totalValue;
		this.customer = customer;
		this.orderItemSet = orderItemSet;
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

	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Set<OrderItem> getOrderItemSet() {
		return orderItemSet;
	}


	public void setOrderItemSet(Set<OrderItem> orderItemSet) {
		this.orderItemSet = orderItemSet;
	}

	
	
}
