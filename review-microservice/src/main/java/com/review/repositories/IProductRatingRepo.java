package com.review.repositories;

import java.util.List;
import java.util.UUID;

import com.review.model.Review;

public interface IProductRatingRepo {

	public List<Review> find(UUID productId);

	public Review save(Review review);

}
