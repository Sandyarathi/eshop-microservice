package com.product.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product;
import com.product.services.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public ResponseEntity<ArrayList<Product>> listAllProducts()   {
		return new ResponseEntity<ArrayList<Product>>(productService.listAll(), HttpStatus.OK);

	}



}
