package com.review.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.model.Review;
import com.review.repositories.IProductRatingRepo;

@Service
public class ReviewService {
	
	@Autowired
	private IProductRatingRepo productRatingRepo;

	public Review addNewRating(Review review) {
		return productRatingRepo.save(review);

	}

	public Review getRating(UUID productId) {
		List<Review> reviewsForProduct = productRatingRepo.find(productId);
		Double rating=0.0;
		Review review = new Review();
		Double sum=0.0;
		for(Review each:reviewsForProduct){
			sum=sum+each.getRating();
		}
		rating= sum/(reviewsForProduct.size());
		review.setProductId(productId);
		review.setRating(rating);
		review.setCustomerId(null);
		return review;
	}
	

}
