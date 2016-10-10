package com.gateway.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gateway.model.Customer;
import com.gateway.model.Product;
import com.gateway.model.ViewProduct;
import com.gateway.service.GatewayService;

@RestController
@RequestMapping("/gateway")
@CrossOrigin
public class GatewayController {

	@Autowired
	GatewayService gatewayService;

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ViewProduct> getProductInfo(@PathVariable("id") UUID productId) {
		return new ResponseEntity<ViewProduct>(gatewayService.getProductInfo(productId),HttpStatus.OK);
	}

	@RequestMapping(value = "/product/all", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> getCatalog() {
		ResponseEntity<List<Product>> responseEntity= gatewayService.getCatalog();
		return responseEntity.getBody();
	}

	@RequestMapping(value = "/customer/create", method = RequestMethod.POST, produces = "application/json", consumes ="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Customer createCustomer(@RequestBody Customer customer) {
		return gatewayService.createCustomer(customer);
	}

	@RequestMapping(value = "/customer/auth", method = RequestMethod.POST, produces = "application/json", consumes ="application/json")
	public ResponseEntity<String> login(@RequestBody Customer customer) {
		boolean success = gatewayService.authenticateUser(customer);
		if(success) {
			ResponseEntity<String> entity = new ResponseEntity<String>(HttpStatus.OK);
			return entity;
		}
		else {
			ResponseEntity<String> entity = new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
			return entity;
		}

	}



}
