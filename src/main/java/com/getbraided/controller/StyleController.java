package com.getbraided.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.getbraided.entity.Style;
import com.getbraided.service.StyleService;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.Response;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/styles")
public class StyleController {

	private static String UPLOADED_FOLDER = "./pictures/";

	@Autowired
	private StyleService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getAllStyles() {
		return new ResponseEntity<Object>(service.getAllStyles(), HttpStatus.OK);
	}

	/*  @RequestMapping(value="/{styleId}", method=RequestMethod.GET)
	  public ResponseEntity<Object> getStyleById()
	  { return new ResponseEntity<Object>(service.getStyleById(styleId), HttpStatus.OK); }

*/
	@RequestMapping(value = "/{styleName}", method = RequestMethod.GET)
	public ResponseEntity<Object> getStyle(@PathVariable String styleName) {
		return new ResponseEntity<Object>(service.getStyle(styleName), HttpStatus.OK);
	}

	@RequestMapping(value = "/stylist/{stylistId}", method = RequestMethod.POST)
	public ResponseEntity<Object> createStyle(@RequestBody Style style, @PathVariable Long stylistId) {
		try {
			return new ResponseEntity<Object>(service.createStyle(style, stylistId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
//fix this. Parent Child issue
	@RequestMapping(value = "/{styleId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteStyle(@PathVariable Long styleId) {
		service.deleteStyle(styleId);
		return new ResponseEntity<Object>("Deleted style with id:" + styleId, HttpStatus.OK);
	}

	@RequestMapping(value = "/{styleId}/stylePicture", method = RequestMethod.POST)
	public ResponseEntity<Object> pictureUpload(@PathVariable Long styleId, @RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return new ResponseEntity<Object>("Please upload a picture)", HttpStatus.BAD_REQUEST);
		}
		try {
			String url = UPLOADED_FOLDER + file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			Path path = Paths.get(url);
			Files.write(path, bytes);
			return new ResponseEntity<Object>(service.pictureUpload(styleId, url), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}