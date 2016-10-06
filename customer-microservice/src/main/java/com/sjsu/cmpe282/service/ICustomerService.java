package com.sjsu.cmpe282.service;

import org.springframework.stereotype.Service;

import com.sjsu.cmpe282.model.Customer;

@Service
public interface ICustomerService {

	public Customer createCustomer(Customer customer);

	public boolean authenticateUser(Customer customer);

}
