package com.skilldistillery.jpabuzzfinder.data;

import java.util.List;

import com.skilldistillery.jpabuzzfinder.entities.Beer;
import com.skilldistillery.jpabuzzfinder.entities.BeerReview;
import com.skilldistillery.jpabuzzfinder.entities.Brewery;
import com.skilldistillery.jpabuzzfinder.entities.BreweryReview;

public interface ReviewDAO {
	
	List<BreweryReview> findReviewByBreweryId( int breweryId);
	
	List<BreweryReview> findReviewByBrewery(Brewery brewery);
	
	BreweryReview addBreweryReview(BreweryReview brewRev);
	
	BreweryReview editBreweryReview(BreweryReview brewRev, int id);
	
	boolean deleteBreweryReview(int reviewId);
	
	List<BeerReview> findReviewByBeerId(int beerId);
	
	BeerReview addBeerReview(BeerReview beerRev);
	
	BeerReview editBeerReview(BeerReview beRev, int id);
	
	boolean deleteBeerReview(int beerId);
	
	public List<BeerReview> findReviewByBeer(Beer beer);

	
	

}
