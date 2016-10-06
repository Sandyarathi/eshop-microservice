package com.order.controllers;


import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.Order;
import com.order.services.OrderService;

@RestController
@RequestMapping("/Order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<ArrayList<Order>> createOrder(@RequestBody ArrayList<Order> orderList)   {
		return new ResponseEntity<ArrayList<Order>>((ArrayList<Order>) orderService.createOrder(orderList), HttpStatus.OK);

	}


}
