package com.oms.customer.resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oms.customer.entity.Customer;
import com.oms.customer.exception.CustomerNotFoundException;
import com.oms.customer.model.CustomerModel;
import com.oms.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerResource {
	
	private static final Logger LOGGER = LogManager.getLogger(CustomerResource.class);

	@Autowired
	private CustomerService customerService;

	@GetMapping("/get/{customerId}")
	public Customer findCustomerById(@PathVariable int customerId) {
		LOGGER.info(">> findCustomerById() from CustomerResource");
		Customer customer = customerService.findCustomerById(customerId);
		if (customer == null) {
			throw new CustomerNotFoundException("Not valid customer");
		}
		LOGGER.info("<< findCustomerById() from CustomerResource");
		return customer;
	}

	@GetMapping("/getCustomerOrders/{customerId}")
	public CustomerModel getCustomerOrders(@PathVariable int customerId) {
		LOGGER.info(">> getCustomerOrders() from CustomerResource");
		CustomerModel customerModel = customerService.getCustomerOrders(customerId);
		LOGGER.info("<< getCustomerOrders() from CustomerResource");
		return customerModel;
	}

	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public void createCustomer(@RequestBody Customer customer) {
		LOGGER.info(">> createCustomer() from CustomerResource");
		customerService.createCustomer(customer);
		LOGGER.info("<< createCustomer() from CustomerResource");
	}

	@PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
	}

	@DeleteMapping(path = "/delete/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteCustomer(@PathVariable int customerId) {
		customerService.deleteCustomer(customerId);
	}

}
