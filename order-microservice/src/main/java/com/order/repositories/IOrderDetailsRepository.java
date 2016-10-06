package com.order.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.order.model.Order;


@Service
public interface IOrderDetailsRepository extends MongoRepository<Order, UUID> {

	public Order findById(UUID id);
	

}
