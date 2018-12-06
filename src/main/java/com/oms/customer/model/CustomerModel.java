package com.oms.customer.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CustomerModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 946848028409056975L;

	
	private int customerId;
	private String name;
	private String email;
	private String phone;
	
	private Set<OrderModel> orderModelSet = new HashSet<OrderModel>();	
	private Set<AddressModel> addressModelSet = new HashSet<AddressModel>();

	public CustomerModel() {
	}

	public CustomerModel(int customerId, String name, String email, String phone, Set<OrderModel> orderModelSet,
			Set<AddressModel> addressModelSet) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.orderModelSet = orderModelSet;
		this.addressModelSet = addressModelSet;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<OrderModel> getOrderModelSet() {
		return orderModelSet;
	}

	public void setOrderModelSet(Set<OrderModel> orderModelSet) {
		this.orderModelSet = orderModelSet;
	}

	public Set<AddressModel> getAddressModelSet() {
		return addressModelSet;
	}

	public void setAddressModelSet(Set<AddressModel> addressModelSet) {
		this.addressModelSet = addressModelSet;
	}

	
}
