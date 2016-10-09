package com.products.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.products.model.Product;

@Service
public interface IProductDetailsRepository extends MongoRepository<Product, UUID> {

	public Product findById(UUID id);

	public List<Product> findAll();

	
	
	

}
