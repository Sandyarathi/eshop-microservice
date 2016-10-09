package com.products.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.products.model.Product;

@Service
public interface IProductDetailsRepository extends MongoRepository<Product, String> {

	public Product findById(String id);

	public List<Product> findAll();

	
	
	

}
