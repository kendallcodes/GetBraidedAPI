package com.getbraided.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	private Date date; 
	private String review; 
	
	@JsonIgnore
	@ManyToOne
	private User user; 

	@JsonIgnore
	@ManyToOne
	private Stylist stylist;


	public Long getId() {

		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	 public User getUser() { 
		  return user; 
	 } 
	  
	 public void setUser(User user) {
		  this.user = user; }
	 
	  public Stylist getStylist() { 
		return stylist; 
		  } 
	  
	  public void setStylist(Stylist stylist) {
		this.stylist = stylist; 
			  }
	 
	
}
