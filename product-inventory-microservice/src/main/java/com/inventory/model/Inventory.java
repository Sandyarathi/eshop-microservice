package com.inventory.model;

import java.util.UUID;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="Inventory")
public class Inventory {
	
	@Id
	private UUID productId;
	private Integer availableStock;
	public UUID getProductId() {
		return productId;
	}
	public void setProductId(UUID productId) {
		this.productId = productId;
	}
	public Integer getAvailableStock() {
		return availableStock;
	}
	public void setAvailableStock(Integer availableStock) {
		this.availableStock = availableStock;
	}
	public Inventory(UUID productId, Integer availableStock) {
		super();
		this.productId = productId;
		this.availableStock = availableStock;
	}
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
