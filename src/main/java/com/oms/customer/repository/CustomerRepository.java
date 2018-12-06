package com.oms.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oms.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
