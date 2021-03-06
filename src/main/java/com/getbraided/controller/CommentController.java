package com.getbraided.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.getbraided.entity.Comment;
import com.getbraided.service.CommentService;


  @RestController
  
  @RequestMapping("/users/{userId}/styles/{styleId}/comments") 
  public class CommentController {
  
  @Autowired
  private CommentService service;
  
  @RequestMapping(method=RequestMethod.POST) 
  public ResponseEntity<Object>createComment(@RequestBody Comment comment, @PathVariable Long userId, @PathVariable Long styleId){ 
	  try  { 
	  return new ResponseEntity<Object>(service.createComment(comment, userId, styleId), HttpStatus.OK); 
  } catch (Exception e) { 
	  return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST); }
  }
  
  @RequestMapping(value="/{commentId}", method=RequestMethod.DELETE)
  public ResponseEntity<Object> deleteComment(@PathVariable Long commentId) {
	  service.deleteComment(commentId); 
	  return new ResponseEntity<Object>("Delete comment with id:" + commentId, HttpStatus.OK);
  }

  }
 