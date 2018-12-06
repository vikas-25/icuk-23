package com.oms.customer.util;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.oms.customer.entity.Address;
import com.oms.customer.entity.Customer;
import com.oms.customer.entity.Order;
import com.oms.customer.entity.OrderItem;
import com.oms.customer.entity.Product;
import com.oms.customer.model.AddressModel;
import com.oms.customer.model.CustomerModel;
import com.oms.customer.model.OrderItemModel;
import com.oms.customer.model.OrderModel;
import com.oms.customer.model.ProductModel;

public class CustomerServiceUtil {
	
	private static final Logger LOGGER = LogManager.getLogger(CustomerServiceUtil.class);
		
	public static CustomerModel setCustomerModel(Customer customer, Set<Order> orderSet) {
		LOGGER.info(">> setCustomerModel() from CustomerServiceUtil");
		CustomerModel customerModel = new CustomerModel();		
		customerModel.setCustomerId(customer.getCustomerId());	
		customerModel.setName(customer.getName());
		customerModel.setEmail(customer.getEmail());
		customerModel.setPhone(customer.getPhone());	
		customerModel.setAddressModelSet(getAddressModelSet(customer.getAddressSet()));
		customerModel.setOrderModelSet(getOrderModelSet(orderSet));	
		LOGGER.info("<< setCustomerModel() from CustomerServiceUtil");
		return customerModel;
	} 
		
	public static Set<AddressModel> getAddressModelSet(Set<Address> addressSet) {
		LOGGER.info(">> getAddressModelSet() from CustomerServiceUtil");
		Set<AddressModel> addressModelSet = new HashSet<AddressModel>();
		addressSet.stream().forEach(address ->{
			AddressModel addressModel = new AddressModel();
			addressModel.setAddressId(address.getAddressId());
			addressModel.setStreet1(address.getStreet1());
			addressModel.setStreet2(address.getStreet2());
			addressModel.setCity(address.getCity());
			addressModel.setState(address.getState());
			addressModel.setZip(address.getZip());
			
			addressModelSet.add(addressModel);			
		});
		LOGGER.info("<< getAddressModelSet() from CustomerServiceUtil");
		return addressModelSet;		
	}
	
	public static Set<OrderModel> getOrderModelSet(Set<Order> orderSet) {
		LOGGER.info(">> getOrderModelSet() from CustomerServiceUtil");
		Set<OrderModel> orderModelSet = new HashSet<OrderModel>();
		orderSet.stream().forEach(order ->{			
			OrderModel orderModel = new OrderModel();
			orderModel.setOrderId(order.getOrderId());
			orderModel.setTotalValue(order.getTotalValue());
			orderModel.setOrderItemModelSet(getOrderItemModelSet(order.getOrderItemSet()));	
			
			orderModelSet.add(orderModel);
		});
		LOGGER.info("<< getOrderModelSet() from CustomerServiceUtil");
		return orderModelSet;		
	}
	
	public static Set<OrderItemModel> getOrderItemModelSet(Set<OrderItem> orderItemSet){
		LOGGER.info(">> getOrderItemModelSet() from CustomerServiceUtil");
		Set<OrderItemModel> orderItemModelSet = new HashSet<OrderItemModel>();		
		orderItemSet.stream().forEach(orderItem ->{
			OrderItemModel orderItemModel = new OrderItemModel();
			orderItemModel.setOrderItemNo(orderItem.getOrderItemNo());
			orderItemModel.setQuantity(orderItem.getQuantity());
			orderItemModel.setProductModel(getProduct(orderItem.getProduct()));			
			
			orderItemModelSet.add(orderItemModel);			
		});
		LOGGER.info("<< getOrderItemModelSet() from CustomerServiceUtil");
		return orderItemModelSet;
	}
	
	public static ProductModel getProduct(Product product) {		
		LOGGER.info(">> getProduct() from CustomerServiceUtil");
		ProductModel productModel = new ProductModel();
		productModel.setProductId(product.getProductId());
		productModel.setName(product.getName());
		productModel.setType(product.getType());
		productModel.setPrice(product.getPrice());		
		LOGGER.info("<< getProduct() from CustomerServiceUtil");
		return productModel;		
	}
}
