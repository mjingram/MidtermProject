package com.skilldistillery.jpabuzzfinder.data;

import java.util.List;

import com.skilldistillery.jpabuzzfinder.entities.Brewery;

public interface BreweryDAO {

	public List<Brewery> findAllBreweries();
	
	Brewery findBreweryById(int id);
	
	public Brewery findBreweryByName(String name);
	
	public List<Brewery> findBreweryByLocation(String city, String state);
	
	Brewery createBrewery(Brewery brewery);
	
    Brewery updateBrewery(Integer id, Brewery brewery);
    
    boolean removeBrewery(int id);
}
