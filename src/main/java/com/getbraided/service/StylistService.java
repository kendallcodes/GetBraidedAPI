package com.getbraided.service;

import com.getbraided.entity.Review;
import com.getbraided.entity.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getbraided.entity.Stylist;
import com.getbraided.repository.StylistRepository;

import java.util.List;


@Service
public class StylistService {
	
	@Autowired
	private StylistRepository repo;
	
	public Iterable<Stylist> getAllStylists() { 
		return repo.findAll(); 
	}
	
	public Stylist findByCity(String city) throws Exception {
		Stylist stylist = repo.findByCity(city); 
		if (stylist == null) { 
			throw new Exception("Cannot find stylists in this city.");
		}
		stylist.getUsername();
		return repo.save(stylist); 	
	}
	
	public Stylist createStylist(Stylist stylist) { 
		return repo.save(stylist); 
	}
	
	public Stylist login(Stylist stylist) throws Exception { 
		Stylist foundStylist = repo.findByUsername(stylist.getUsername());
		if (foundStylist != null & foundStylist.getPassword().equals(stylist.getPassword())) { 
			return foundStylist; 
		} else { 
			throw new Exception("Sorry! Wrong username or password! Please try again.");
		}
	}

public List<Review> getAllReviewsByUsername(String username) throws Exception {
	Stylist foundStylist = repo.getAllReviewsByUsername(username);
	if (foundStylist == null) {
		throw new Exception("Cannot find reviews for this stylist.");
	}
	return foundStylist.getReviews();
}
//	public List<Style> getAllStylesByStylist(String username) throws Exception {
//		Stylist foundStylist = repo.getAllStylesByStylist(username);
//		if (foundStylist == null) {
//			throw new Exception("Cannot find styles for this stylist.");
//		}
//		return foundStylist.getStyle();
//	}

	  }


