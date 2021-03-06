package com.getbraided.repository;

import org.springframework.data.repository.CrudRepository;

import com.getbraided.entity.Review;
import com.getbraided.entity.Stylist;

public interface ReviewRepository extends CrudRepository<Review, Long>{



}
