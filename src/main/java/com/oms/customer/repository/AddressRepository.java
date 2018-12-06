package com.oms.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oms.customer.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
