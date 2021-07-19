package com.skilldistillery.jpabuzzfinder.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="beer_review")
public class BeerReview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="review_date")
	private LocalDate reviewDate;
	
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="beer_id")
	private Beer beer;

	
	public BeerReview() {}
	
	
	public BeerReview(LocalDate reviewDate, String comment, Beer beer) {
		super();
		this.reviewDate = reviewDate;
		this.comment = comment;
		this.beer = beer;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(LocalDate reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Beer getBeer() {
		return beer;
	}

	public void setBeer(Beer beer) {
		this.beer = beer;
	}

	@Override
	public String toString() {
		return "BeerReview [id=" + id + ", reviewDate=" + reviewDate + ", comment=" + comment + ", user=" + user + "]";
	}
	
	
}
