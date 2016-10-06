package com.review.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.review.model.Review;
import com.review.service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping(value = "/addRating", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<Review> addNewRating(@RequestBody Review review)   {
		return new ResponseEntity<Review>(reviewService.addNewRating(review), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/{productId}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public ResponseEntity<Review> getAverageRating(@PathVariable UUID productId)   {
		return new ResponseEntity<Review>(reviewService.getRating(productId), HttpStatus.OK);

	}
	
	
	
	
	
}
	
		



