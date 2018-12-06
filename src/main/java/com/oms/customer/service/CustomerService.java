package com.oms.customer.service;

import com.oms.customer.entity.Customer;
import com.oms.customer.model.CustomerModel;

public interface CustomerService {
	
	public Customer findCustomerById(int customerId);
	
	public Customer findAllCustomers();
	
	public void createCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(int customerId);
	
	public CustomerModel getCustomerOrders(int customerId);

}
