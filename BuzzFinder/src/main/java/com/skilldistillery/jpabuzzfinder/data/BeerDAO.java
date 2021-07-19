package com.skilldistillery.jpabuzzfinder.data;

import java.util.List;

import com.skilldistillery.jpabuzzfinder.entities.Beer;
import com.skilldistillery.jpabuzzfinder.entities.BeerStyle;

public interface BeerDAO {
	
	Beer findBeerById(int id);
	
	Beer findBeerByName(String name);
	
	BeerStyle findBeerByStyle(BeerStyle beerStyle);
	
	List<Beer> findAllBeers();
	
	Beer addBeerToProfile(Beer beer);
	
	Beer updateBeerProfile(Beer beer);
	
	boolean deleteBeerFromProfile(int id);
	

}
