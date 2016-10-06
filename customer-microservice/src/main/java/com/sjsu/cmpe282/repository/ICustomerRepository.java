package com.sjsu.cmpe282.repository;

import com.sjsu.cmpe282.model.Customer;


public interface ICustomerRepository {

	public Customer createCustomer(Customer customer);

	public boolean authenticateUser(Customer customer);
	

}
