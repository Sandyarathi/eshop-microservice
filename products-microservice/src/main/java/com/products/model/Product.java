package com.products.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="product")
public class Product {
	@Id
	private UUID id;
	private String productName;
	private Double productPrice;
	private String description;
	private String category;

	public Product(UUID id, String productName, Double productPrice,
			String description, String category) {
		super();
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.description = description;
		this.category = category;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", description="
				+ description + ", category=" + category + "]";
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
