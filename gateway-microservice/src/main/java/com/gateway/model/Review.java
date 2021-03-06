package com.gateway.model;

import java.util.UUID;

public class Review {
	private UUID productId;
	private double rating;
	private UUID customerId;

	public UUID getCustomerId() {
		return customerId;
	}
	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}
	public UUID getProductId() {
		return productId;
	}
	public void setProductId(UUID productId) {
		this.productId = productId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	

}
