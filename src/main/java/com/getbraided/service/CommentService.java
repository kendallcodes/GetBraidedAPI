package com.getbraided.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getbraided.entity.Comment;
import com.getbraided.entity.Style;
import com.getbraided.entity.User;
import com.getbraided.repository.CommentRepository;
import com.getbraided.repository.StyleRepository;
import com.getbraided.repository.UserRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository repo; 
	
	@Autowired
	private StyleRepository styleRepo;
	
	@Autowired
	private UserRepository userRepo; 
	
	public Comment createComment(Comment comment, Long userId, Long styleId) throws Exception { 
		User user = userRepo.findOne(userId); 
		Style style = styleRepo.findOne(styleId);
		if (user == null || style == null) { 
			throw new Exception("User or style does not exist!");
		}
		comment.setDate(new Date());
		comment.setUser(user);
		comment.setStyle(style);
		return repo.save(comment);
	}
	
	public void deleteComment(Long commentId) { 
		repo.delete(commentId);
	}
	

}
