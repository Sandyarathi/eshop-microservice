package com.inventory.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.inventory.model.Inventory;
@Service
public interface InventoryRepository extends  MongoRepository<Inventory, UUID> {
	public Inventory findByProductId(UUID productId);
	public Inventory save(Inventory inventory);
	
}