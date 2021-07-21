package com.skilldistillery.jpabuzzfinder.data;

import java.util.List;

import com.skilldistillery.jpabuzzfinder.entities.Beer;
import com.skilldistillery.jpabuzzfinder.entities.BeerReview;
import com.skilldistillery.jpabuzzfinder.entities.Brewery;
import com.skilldistillery.jpabuzzfinder.entities.BreweryReview;

public interface ReviewDAO {
	
	List<BreweryReview> findByBreweryId( int breweryId);
	
	List<BreweryReview> findByBrewery(Brewery brewery);
	
	BreweryReview addBreweryReview(BreweryReview brewRev);
	
	BreweryReview editBreweryReview(BreweryReview brewRev, int id);
	
	boolean deleteBreweryReview(int reviewId);
	
	List<BeerReview> findByBeerId(int beerId);
	
	List<BeerReview> findByBeer(Beer beer);
	
	BeerReview addBeerReview(BeerReview beerRev);
	
	BeerReview editBeerReview(BeerReview beRev, int id);
	
	boolean deleteBeerReview(int beerId);

	
	

}
