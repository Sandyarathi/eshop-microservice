package com.sjsu.cmpe282.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sjsu.cmpe282.exception.ServiceException;
import com.sjsu.cmpe282.model.Customer;
import com.sjsu.cmpe282.rabbitmq.TaskMessage;
import com.sjsu.cmpe282.rabbitmq.TaskProducer;
import com.sjsu.cmpe282.repository.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	private ICustomerRepository iCustomerRepository;
	
	@Autowired
	private TaskProducer taskProducer;

	@Override
	public Customer createCustomer(Customer customer) {
		customer.setCustomerId(UUID.randomUUID());
		customer.setCreateDate(new Date());
		if (!isValidCreateUserRequest(customer)) {
			throw new ServiceException("Invalid create user request.");
		}
		sendEmail(customer.getEmail());
		return iCustomerRepository.createCustomer(customer);
	}

	private void sendEmail(String email) {
		TaskMessage taskMessage = new TaskMessage();
		taskMessage.setEmailId(email);
		taskProducer.sendNewTask(taskMessage);
			
	}

	private boolean isValidCreateUserRequest(Customer customer) {
		boolean isValid = false;
		if (customer != null && !StringUtils.isEmpty(customer.getCustomerId())
				&& !StringUtils.isEmpty(customer.getPassword())) {
			isValid=true;
		}
		System.out.println(">>>>> isValidCreateUserRequest: " + isValid);

		return isValid;
	}

	
	@Override
	public boolean authenticateUser(Customer customer) {
		boolean isAuthenticated = false;
		if (customer != null) {
			if (!StringUtils.isEmpty(customer.getCustomerId())
					&& !StringUtils.isEmpty(customer.getPassword())) {
				isAuthenticated = iCustomerRepository.authenticateUser(customer);
			}
		}

		return isAuthenticated;
	}

}
