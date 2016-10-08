package com.apigateway.model;

import java.io.Serializable;

/**
 * @author sandyarathidas
 *
 */
public class ViewProduct implements Serializable{
	
	private static final long serialVersionUID = -8243145429438016231L;

	private Product productBasicInfo;
	private Double productRating;
	private Integer productInventory;
	

	public Product getProductBasicInfo() {
		return productBasicInfo;
	}

	public void setProductBasicInfo(Product productBasicInfo) {
		this.productBasicInfo = productBasicInfo;
	}

	public Double getProductRating() {
		return productRating;
	}

	public void setProductRating(Double productRating) {
		this.productRating = productRating;
	}

	public Integer getProductInventory() {
		return productInventory;
	}

	public void setProductInventory(Integer productInventory) {
		this.productInventory = productInventory;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ViewProduct(Product productBasicInfo, Double productRating, Integer productInventory) {
		super();
		this.productBasicInfo = productBasicInfo;
		this.productRating = productRating;
		this.productInventory = productInventory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productBasicInfo == null) ? 0 : productBasicInfo.hashCode());
		result = prime * result + ((productInventory == null) ? 0 : productInventory.hashCode());
		result = prime * result + ((productRating == null) ? 0 : productRating.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViewProduct other = (ViewProduct) obj;
		if (productBasicInfo == null) {
			if (other.productBasicInfo != null)
				return false;
		} else if (!productBasicInfo.equals(other.productBasicInfo))
			return false;
		if (productInventory == null) {
			if (other.productInventory != null)
				return false;
		} else if (!productInventory.equals(other.productInventory))
			return false;
		if (productRating == null) {
			if (other.productRating != null)
				return false;
		} else if (!productRating.equals(other.productRating))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ViewProduct [productBasicInfo=" + productBasicInfo + ", productRating=" + productRating
				+ ", productInventory=" + productInventory + "]";
	}

}
