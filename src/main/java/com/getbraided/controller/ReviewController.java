package com.getbraided.controller;

import com.getbraided.entity.Review;
import com.getbraided.entity.Stylist;
import com.getbraided.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;


@RestController
  @RequestMapping("/stylists/{stylistId}/reviews")
  public class ReviewController {

  @Autowired
  private ReviewService service;


  @RequestMapping(value = "/user/{userId}", method = RequestMethod.POST)
  public ResponseEntity<Object> createReview(@RequestBody Review review, @PathVariable Long userId, @PathVariable Long stylistId) {
    try {
      return new ResponseEntity<Object>(service.createReview(review, userId, stylistId), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(value = "/{reviewId}", method = RequestMethod.PUT)
  public ResponseEntity<Object> updateReview(@RequestBody Review review, @PathVariable Long reviewId) {
    try {
      return new ResponseEntity<Object>(service.updateReview(review, reviewId), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }




}