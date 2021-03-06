package com.getbraided.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.getbraided.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.getbraided.entity.Stylist;
import com.getbraided.service.StylistService;
import com.getbraided.entity.Style;

@RestController
@RequestMapping("/stylists")
public class StylistController {

	private static String UPLOADED_FOLDER = "./pictures/";

	@Autowired
	private StylistService service;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Object> register(@RequestBody Stylist stylist) {
		return new ResponseEntity<Object>(service.createStylist(stylist), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Object> login(@RequestBody Stylist stylist) {
		try {
			return new ResponseEntity<Object>(service.login(stylist), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getAllStylists() {
		return new ResponseEntity<Object>(service.getAllStylists(), HttpStatus.OK);
	}

	@RequestMapping(value = "/reviews/{username}", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllReviewsByUsername(@PathVariable String username) {
		try {
			return new ResponseEntity<Object>(service.getAllReviewsByUsername(username), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// write Delete Stylist

//	@RequestMapping(value = "/styles/{username}", method = RequestMethod.GET)
//	public ResponseEntity<Object> getAllStylesByStylist(@PathVariable String username) {
//		try {
//			return new ResponseEntity<Object>(service.getAllStylesByStylist(username), HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
//		}
//
//	}


}