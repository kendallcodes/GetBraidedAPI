package com.getbraided.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username; 
	private String password;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Comment> comments;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Set<Review> reviews;

	@ManyToMany
	private Set<Style> likesStyles;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

 public Set<Review> getReviews() { 
	 	return reviews; 
 }
 
  public void setReviews(Set<Review> reviews) { 
  
  }

}
