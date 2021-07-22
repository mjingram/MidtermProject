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
	
	private String taste;
	
	private String body;
	
	private Integer rating;
	
	private String again;
	

	
	public BeerReview() {}
	
	
	public BeerReview(int id, LocalDate reviewDate, String comment, Beer beer, String taste, String body, int rating,
			String again) {
		super();
		this.id = id;
		this.reviewDate = reviewDate;
		this.comment = comment;
		this.beer = beer;
		this.taste = taste;
		this.body = body;
		this.rating = rating;
		this.again = again;
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

	public String getTaste() {
		return taste;
	}


	public void setTaste(String taste) {
		this.taste = taste;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}


	public String getAgain() {
		return again;
	}


	public void setAgain(String again) {
		this.again = again;
	}


	@Override
	public String toString() {
		return "BeerReview [id=" + id + ", reviewDate=" + reviewDate + ", comment=" + comment + ", user=" + user + "]";
	}
	
	
}
