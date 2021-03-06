package com.getbraided.repository;

import com.getbraided.entity.Review;
import org.springframework.data.repository.CrudRepository;

import com.getbraided.entity.Stylist;

public interface StylistRepository extends CrudRepository<Stylist, Long> {

	Stylist findByCity(String city);

	Stylist findByUsername(String username);

	Stylist getAllReviewsByUsername(String username);

	//Stylist getAllStylesByStylist(String username);




}
