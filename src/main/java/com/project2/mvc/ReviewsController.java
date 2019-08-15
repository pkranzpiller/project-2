package com.project2.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project2.data.Reviews;
import com.project2.data.ReviewsRepository;

@CrossOrigin
@RestController
@RequestMapping(path = "reviews")
public class ReviewsController {
	
	@Autowired
	ReviewsRepository reviewsRepository;
	
	@Autowired
	RestTemplate restTemplate;

	@PostMapping(path = "/getReviews")
	public List<Reviews> getReviews(@RequestBody String animename){
		return this.reviewsRepository.getReviews(animename);
	}
	
	@PostMapping
	public void storeReviews(@RequestBody Reviews review) {
		this.reviewsRepository.storeReview(review);
	}

}
