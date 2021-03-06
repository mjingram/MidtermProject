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
@Table(name="brewery_review")
public class BreweryReview {
	
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
	@JoinColumn(name="brewery_id")
	private Brewery brewery;
	
	@Column(name = "favorite_beer")
	private String favoriteBeer;
	
	private Integer rating;
	
	private String again;
	
	private String feature;

	
	public BreweryReview () {}
	
	


	public BreweryReview(int id, LocalDate reviewDate, String comment, Brewery brewery, String favoriteBeer,
			int rating, String again, String feature) {
		super();
		this.id = id;
		this.reviewDate = reviewDate;
		this.comment = comment;
		this.brewery = brewery;
		this.favoriteBeer = favoriteBeer;
		this.rating = rating;
		this.again = again;
		this.feature = feature;
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

	public Brewery getBrewery() {
		return brewery;
	}

	public void setBrewery(Brewery brewery) {
		this.brewery = brewery;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BreweryReview other = (BreweryReview) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String getFavoriteBeer() {
		return favoriteBeer;
	}




	public void setFavoriteBeer(String favoriteBeer) {
		this.favoriteBeer = favoriteBeer;
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




	public String getFeature() {
		return feature;
	}




	public void setFeature(String feature) {
		this.feature = feature;
	}




	@Override
	public String toString() {
		return "BreweryReview [id=" + id + ", reviewDate=" + reviewDate + ", comment=" + comment + ", user=" + user
				+ ", brewery=" + brewery + "]";
	}
	
	

}
