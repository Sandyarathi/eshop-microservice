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
	public boolean authenticateCustomer(Customer customer) {
		boolean isAuthenticated = false;
		String email = customer.getEmail();
		String password = customer.getPassword();
		System.out.println("EMAIL"+email);
		System.out.println("PASSWORD"+password);
		String cql = "select * from customer where email = '" + email
				+ "' allow filtering";
		Customer dbCustomer = operations.selectOne(cql, Customer.class);
		if(dbCustomer==null){
			System.out.println("****NO RECORD FOUND!!******");
		}
		System.out.println(">>>> DB password: " + dbCustomer.getPassword()
				+ ", User password: " + password);

		if (dbCustomer != null && password.equals(dbCustomer.getPassword())) {
			isAuthenticated = true;
			System.out.println("**IS AUTH IS TRUE"+isAuthenticated);
		}
		else{
			System.out.println("**IS AUTH IS FALSE"+isAuthenticated);
		}
		System.out.println("**IS AUTH IS FALSE"+isAuthenticated);
		return isAuthenticated;
	}

}
