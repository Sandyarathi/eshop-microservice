package com.inventory.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.model.Inventory;
import com.inventory.repository.InventoryRepository;
@Service
public class InventoryService {
	@Autowired
	InventoryRepository inventoryRepo;

	public Inventory getInventory(UUID productId) {
		// TODO Auto-generated method stub
		return inventoryRepo.findByProductId(productId);
	}


	public Inventory createInventory(Inventory inventory) {	
		
		return inventoryRepo.save(inventory);
	}


	public void deleteAllInventory() {
		// TODO Auto-generated method stub
		inventoryRepo.deleteAll();
	}

}
