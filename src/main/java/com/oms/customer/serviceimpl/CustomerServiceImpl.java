package com.oms.customer.serviceimpl;


import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.customer.client.OrderServiceClient;
import com.oms.customer.entity.Address;
import com.oms.customer.entity.Customer;
import com.oms.customer.entity.Order;
import com.oms.customer.model.CustomerModel;
import com.oms.customer.repository.AddressRepository;
import com.oms.customer.repository.CustomerRepository;
import com.oms.customer.service.CustomerService;
import com.oms.customer.util.CustomerServiceUtil;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private static final Logger LOGGER = LogManager.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private OrderServiceClient orderServiceClient;
	
	
		
	@Override
	public Customer findCustomerById(int customerId) {
		LOGGER.info(">> findCustomerById() from CustomerServiceImpl");
		Customer customer = customerRepository.getOne(customerId);
		LOGGER.info("<< findCustomerById() from CustomerServiceImpl");
		return customer;
	}

	@Override
	public Customer findAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCustomer(Customer customer) {		
		customerRepository.save(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {		
		Set<Address> addressSet = customer.getAddressSet();
		addressSet.forEach(address ->{
			Address updateAddress = addressRepository.getOne(address.getAddressId());
			if(updateAddress!=null) {
				addressRepository.save(address);
			}
			
		});
		customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(int customerId) {
		customerRepository.deleteById(customerId);
		
	}

	@Override
	public CustomerModel getCustomerOrders(int customerId) {
		LOGGER.info(">> getCustomerOrders() from CustomerServiceImpl");
		Customer customer = customerRepository.getOne(customerId);		
		Set<Order> orderSet = orderServiceClient.findOrdersByCustomerId(customerId);
		CustomerModel customerModel = CustomerServiceUtil.setCustomerModel(customer, orderSet);
		LOGGER.info("<< getCustomerOrders() from CustomerServiceImpl");
		return customerModel;
	}
	
	

}
