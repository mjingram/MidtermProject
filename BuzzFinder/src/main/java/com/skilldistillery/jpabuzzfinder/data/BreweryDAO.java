package com.skilldistillery.jpabuzzfinder.data;

import com.skilldistillery.jpabuzzfinder.entities.Brewery;

public interface BreweryDAO {

	Brewery findBreweryById(int id);
	Brewery createBrewery(Brewery brewery);
    Brewery updateBrewery(Integer id, Brewery brewery);
    boolean removeBrewery(int id);
}
