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
	
	public User updateUsernameAndPassword(String password, User user);
	
	public boolean deleteByUsername(String username, String password);
	
	public User login(String username, String password);
	
	public Beer addFavBeer(User user, Beer beer);
	
	public Brewery addFavBrewery(User user, Brewery brewery);
	
	public BreweryReview addBreweryReview(User user, BreweryReview breweryReview);
	
	public BeerReview addBeerReview(User user, BeerReview beerReview);
	
	public User updateFavBeerStyle(BeerStyle bs, User user);
	
	public boolean removeFavBeer(User user, Beer beer);
	
	public boolean removeFavBrewery(User user, Brewery brewery);
	
	public boolean removeBeerReview(User user, BeerReview beerReview);
	
	public boolean removeBreweryReview(User user, BreweryReview breweryReview);
	
	public List<BeerReview> updateBeerReview(BeerReview beerReview, User user); 
	
	public List<BreweryReview> updateBreweryReview(BreweryReview breweryReview, User user);
	
}

