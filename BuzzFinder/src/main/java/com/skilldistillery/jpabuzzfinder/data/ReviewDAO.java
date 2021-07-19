package com.skilldistillery.jpabuzzfinder.data;

import java.util.List;

import com.skilldistillery.jpabuzzfinder.entities.Beer;
import com.skilldistillery.jpabuzzfinder.entities.BeerReview;
import com.skilldistillery.jpabuzzfinder.entities.Brewery;
import com.skilldistillery.jpabuzzfinder.entities.BreweryReview;

public interface ReviewDAO {
	
	List<BreweryReview> findByBreweryId(BreweryReview brewRev, int breweryId);
	
	List<BreweryReview> findByBrewery(Brewery brewery);
	
	BreweryReview addBrewComment(BreweryReview brewRev);
	
	BreweryReview editBrewComment(BreweryReview brewRev, int id);
	
	boolean deleteBrewComment(BreweryReview brewRev);
	
	BeerReview findBeerId(int beerId);
	
	BeerReview findByBeer(Beer beer);
	
	String addBeerComment(String string);
	
	BeerReview editBeerComment(BeerReview beRev, int id);
	
	boolean deleteBeerComment(BeerReview beRev);

}
