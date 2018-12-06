package com.oms.customer.client;

import java.util.Set;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.oms.customer.entity.Order;

@FeignClient(name = "oms-order-service")
public interface OrderServiceClient {

	@GetMapping("order/getOrders/{customerId}")
	public Set<Order> findOrdersByCustomerId(@PathVariable int customerId);

}
