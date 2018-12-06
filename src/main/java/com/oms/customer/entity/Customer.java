package com.oms.customer.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The Class Customer.
 */
@Entity
@Table(name = "customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 946848028409056975L;

	/** The customer id. */
	@Id
	private int customerId;
	
	/** The name. */
	private String name;
	
	/** The email. */
	private String email;
	
	/** The phone. */
	private String phone;

	
	/** The address set. */
	@JsonManagedReference(value="customer-address")
	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Address> addressSet = new HashSet<Address>();
	
	/** The order set. */
	/*@JsonManagedReference(value="customer-order")
	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Order> orderSet = new HashSet<Order>();*/

	/**
	 * Instantiates a new customer.
	 */
	public Customer() {
	}

	/**
	 * Instantiates a new customer.
	 *
	 * @param customerId the customer id
	 * @param name the name
	 * @param email the email
	 * @param phone the phone
	 * @param addressSet the address set
	 * @param orderSet the order set
	 */
	public Customer(int customerId, String name, String email, String phone, Set<Address> addressSet
			) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.addressSet = addressSet;
		
	}

	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Sets the customer id.
	 *
	 * @param customerId the new customer id
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the address set.
	 *
	 * @return the address set
	 */
	public Set<Address> getAddressSet() {
		return addressSet;
	}

	/**
	 * Sets the address set.
	 *
	 * @param addressSet the new address set
	 */
	public void setAddressSet(Set<Address> addressSet) {
		this.addressSet = addressSet;
	}

	
}
