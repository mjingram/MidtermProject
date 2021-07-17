package com.skilldistillery.jpabuzzfinder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FavoriteBeer {
	
	@Id
	@Column(name = "user_id")
	private int userId;
	
//	@Column(name = "beer_id")
//	private int beerId;
	
	private Beer beer;

	public FavoriteBeer() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}



	public Beer getBeer() {
		return beer;
	}

	public void setBeer(Beer beer) {
		this.beer = beer;
	}

	@Override
	public String toString() {
		return "FavoriteBeer [userId=" + userId + ", beerId=" + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
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
		FavoriteBeer other = (FavoriteBeer) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

	


}
