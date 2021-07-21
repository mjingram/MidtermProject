package com.skilldistillery.jpabuzzfinder.data;

import java.util.List;

import com.skilldistillery.jpabuzzfinder.entities.Beer;
import com.skilldistillery.jpabuzzfinder.entities.BeerReview;
import com.skilldistillery.jpabuzzfinder.entities.Brewery;
import com.skilldistillery.jpabuzzfinder.entities.BreweryReview;

public interface ReviewDAO {
	
	List<BreweryReview> findByBreweryId( int breweryId);
	
	List<BreweryReview> findByBrewery(Brewery brewery);
	
	BreweryReview addBrewComment(BreweryReview brewRev);
	
	BreweryReview editBrewComment(BreweryReview brewRev, int id);
	
	boolean deleteBrewComment(int reviewId);
	
	List<BeerReview> findByBeerId(int beerId);
	
	List<BeerReview> findByBeer(Beer beer);
	
	BeerReview addBeerComment(BeerReview beerRev);
	
	BeerReview editBeerComment(BeerReview beRev, int id);
	
	boolean deleteBeerComment(int beerId);
	
	

}
