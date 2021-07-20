package com.skilldistillery.jpabuzzfinder.data;

import java.util.List;

import com.skilldistillery.jpabuzzfinder.entities.Beer;
import com.skilldistillery.jpabuzzfinder.entities.BeerStyle;

public interface BeerDAO {
	
	Beer findBeerById(int id);
	
	List<Beer> findBeerByName(String name);
	
	List<Beer> findBeerByStyle(String beerStyle);
	
	List<Beer> findAllBeers();
	
	Beer addBeerToProfile(Beer beer);
	
	Beer updateBeerProfile(Beer beer);
	
	boolean deleteBeerFromProfile(int id);
	
	List<Beer> faveBeerList(int id);
	

}
