package com.review.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.review.model.Review;

public interface IProductRatingRepo extends  CrudRepository<Review, UUID>{

	public List<Review> find(UUID productId);

	public Review save(Review review);
	
	public Review update(Review review);

}
