package com.order.services;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.model.Order;
import com.order.repositories.IOrderDetailsRepository;

@Service
public class OrderService {
	
	@Autowired
	private IOrderDetailsRepository orderDetailsRepo;
	
	private Log log = LogFactory.getLog(OrderService.class);

	public List<Order> createOrder(List<Order> orderList) {	
		return orderDetailsRepo.save(orderList);
	}

}
