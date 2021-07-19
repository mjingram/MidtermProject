package com.skilldistillery.jpabuzzfinder.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
//////////////////////// Fields //////////////////////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String username;

	private String password;

	private int enabled;

	private String role;

	@OneToOne
	@JoinTable(name = "favorite_style", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "beer_style_id"))
	private BeerStyle favoriteStyle;

	@OneToMany
	@JoinTable(name = "favorite_beer", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "beer_id"))
	private List<Beer> favBeers;

	@OneToMany
	@JoinTable(name = "favorite_brewery", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "brewery_id"))
	private List<Brewery> favBreweries;

	@OneToMany(mappedBy = "user")
	private List<BeerReview> beerReviews;

	@OneToMany(mappedBy = "user")
	private List<BreweryReview> breweryReviews;

/////////////////////// Methods /////////////////////////////

	public User() {
	}

	public BeerStyle getFavoriteStyle() {
		return favoriteStyle;
	}

	public void setFavoriteStyle(BeerStyle favoriteStyle) {
		this.favoriteStyle = favoriteStyle;
	}

	public List<Beer> getFavoriteBeers() {
		return favBeers;
	}

	public void setFavoriteBeers(List<Beer> favoriteBeers) {
		this.favBeers = favoriteBeers;
	}

	public List<Brewery> getFavoriteBreweries() {
		return favBreweries;
	}

	public void setFavoriteBreweries(List<Brewery> favoriteBreweries) {
		this.favBreweries = favoriteBreweries;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<BeerReview> getBeerReviews() {
		return beerReviews;
	}

	public void setBeerReviews(List<BeerReview> beerReviews) {
		this.beerReviews = beerReviews;
	}

	public List<BreweryReview> getBreweryReviews() {
		return breweryReviews;
	}

	public void setBreweryReviews(List<BreweryReview> breweryReviews) {
		this.breweryReviews = breweryReviews;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + enabled;
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (enabled != other.enabled)
			return false;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public void addFavBeer(Beer beer) {

		if (!favBeers.contains(beer)) {
			favBeers.add(beer);

			if (favBeers.contains(beer)) {
				favBeers.remove(beer);
			}
			favBeers.add(beer);
			;
		}
	}
	
	public void removeBeerFromFavs(Beer beer) {
		if (favBeers != null) {
			favBeers.remove(beer);
		}
	}
	
	public void addFavBrewery(Brewery brewery) {
		
		if (!favBreweries.contains(brewery)) {
			favBreweries.add(brewery);
			
			if (favBreweries.contains(brewery)) {
				favBreweries.remove(brewery);
			}
			favBreweries.add(brewery);
			;
		}
	}
	
	public void removeBreweryFromFavs(Brewery brewery) {
		if (favBreweries != null) {
			favBreweries.remove(brewery);
		}
	}
	
	public void addBreweryReview(BreweryReview breweryReview) {
		
		if (!breweryReviews.contains(breweryReview)) {
			breweryReviews.add(breweryReview);
			
			if (breweryReviews.contains(breweryReview)) {
				breweryReviews.remove(breweryReview);
			}
			breweryReviews.add(breweryReview);
			;
		}
	}
	
	public void removeBreweryReview(BreweryReview breweryReview) {
		if (breweryReviews != null) {
			breweryReviews.remove(breweryReview);
		}
	}
	
	public void addBeerReview(BeerReview beerReview) {
		
		if (!beerReviews.contains(beerReview)) {
			beerReviews.add(beerReview);
			
			if (beerReviews.contains(beerReview)) {
				beerReviews.remove(beerReview);
			}
			beerReviews.add(beerReview);
			;
		}
	}
	
	public void removeBeerReview(BeerReview beerReview) {
		if (beerReviews != null) {
			beerReviews.remove(beerReview);
		}
	}

}
