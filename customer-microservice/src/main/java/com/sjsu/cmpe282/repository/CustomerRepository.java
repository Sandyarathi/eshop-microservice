package com.sjsu.cmpe282.repository;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.sjsu.cmpe282.model.Customer;

@Repository
public class CustomerRepository implements ICustomerRepository {

	@Autowired
	private CassandraOperations operations;

	@Override
	public Customer createCustomer(Customer customer) {
		Customer createdCustomer = operations.insert(customer);
		createdCustomer.setPassword("********");
		return createdCustomer;

	}

	@Override
	public boolean authenticateUser(Customer customer) {
		boolean isAuthenticated = false;
		String email = customer.getEmail();
		String password = customer.getPassword();

		String cql = "select * from customer where email = '" + email
				+ "' allow filtering";
		Customer dbCustomer = operations.selectOne(cql, Customer.class);

		System.out.println(">>>> DB password: " + dbCustomer.getPassword()
				+ ", User password: " + password);

		if (dbCustomer != null && password.equals(dbCustomer.getPassword())) {
			isAuthenticated = true;
		}

		return isAuthenticated;
	}

}
