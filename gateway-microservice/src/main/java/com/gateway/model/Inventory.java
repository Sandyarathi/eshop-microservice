package com.gateway.model;

import java.util.UUID;

public class Inventory {
	
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
	
	
	

}
