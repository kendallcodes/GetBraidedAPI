package com.getbraided.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getbraided.entity.Review;
import com.getbraided.entity.Stylist;
import com.getbraided.entity.User;
import com.getbraided.repository.ReviewRepository;
import com.getbraided.repository.StylistRepository;
import com.getbraided.repository.UserRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository repo;
	
	@Autowired
	private StylistRepository stylistRepo; 
	
	@Autowired
	private UserRepository userRepo; 
	
	//public Review getAllReviewsByUsername(String username) {
		//return repo.findAllByUsername(username);
	//}
	
	public Review createReview(Review review, Long userId, Long stylistId) throws Exception { 
		User user = userRepo.findOne(userId); 
		Stylist stylist = stylistRepo.findOne(stylistId);
		if (user == null || stylist == null) { 
			throw new Exception("User or stylist does not exist");
		}
		review.setDate(new Date());
		review.setUser(user);
		review.setStylist(stylist);
		return repo.save(review);
	}
	
	public Review updateReview(Review review, Long reviewId) throws Exception { 
		Review foundReview = repo.findOne(reviewId);
		if (foundReview == null) { 
			throw new Exception("Review cannot be found.");
		}
		foundReview.setReview(review.getReview());
		return repo.save(foundReview);
	}


}
