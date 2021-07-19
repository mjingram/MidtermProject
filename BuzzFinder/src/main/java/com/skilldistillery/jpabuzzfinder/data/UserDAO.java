package com.skilldistillery.jpabuzzfinder.data;

import java.util.List;

import com.skilldistillery.jpabuzzfinder.entities.Beer;
import com.skilldistillery.jpabuzzfinder.entities.BeerReview;
import com.skilldistillery.jpabuzzfinder.entities.BeerStyle;
import com.skilldistillery.jpabuzzfinder.entities.Brewery;
import com.skilldistillery.jpabuzzfinder.entities.BreweryReview;
import com.skilldistillery.jpabuzzfinder.entities.User;

public interface UserDAO {
	
	public User createUser(User user);
	
	public User findById(int userId);
	
	public User updateUsernameAndPassword(String password, int userId);
	
	public boolean deleteUser(int userId);
	
	public User login(String username, String password);
	
	public Beer addFavBeer(int user, Beer beer);
	
	public Brewery addFavBrewery(int userId, Brewery brewery);
	
	public BreweryReview addBreweryReview(int userId, BreweryReview breweryReview);
	
	public BeerReview addBeerReview(int userId, BeerReview beerReview);
	
	public User updateFavBeerStyle(int userId, BeerStyle bs);
	
	public boolean removeFavBeer(int userId, Beer beer);
	
	public boolean removeFavBrewery(int userId, Brewery brewery);
	
	public boolean removeBeerReview(int userId, BeerReview beerReview);
	
	public boolean removeBreweryReview(int userId, BreweryReview breweryReview);
	
	public List<BeerReview> updateBeerReviews(int userId, BeerReview beerReview); 
	
	public List<BreweryReview> updateBreweryReviews(int userId, BreweryReview breweryReview);
	
}

