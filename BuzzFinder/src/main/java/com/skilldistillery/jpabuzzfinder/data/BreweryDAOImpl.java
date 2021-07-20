package com.skilldistillery.jpabuzzfinder.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpabuzzfinder.entities.Brewery;

@Service
@Transactional
public class BreweryDAOImpl implements BreweryDAO {

	@PersistenceContext
	private EntityManager em;


///////////// Find Brewery By Id ////////////////
	
//	findBreweryByName
//	findBreweryByLocation
	
	@Override
	public Brewery findBreweryById(int id) {
		return em.find(Brewery.class, id);
	}
	
	@Override
	public Brewery findBreweryByName(String name) {
//		Brewery brewery = 
		return em.find(Brewery.class, name);
	}
	
	@Override
	public Brewery findBreweryByLocation(String city) {
		return em.find(Brewery.class, city);
	}
///////////// Create Brewery  //////////////////
	@Override
	public Brewery createBrewery(Brewery brewery) {
		em.persist(brewery);
		return brewery;
	}

///////////// Remove a Brewery ////////////////
	@Override
	public boolean removeBrewery(int id) {
		boolean check = false;
		Brewery brewery = em.find(Brewery.class, id);
		if (brewery != null) {
			em.remove(brewery);
			return true;

		}
		return check;
	}

///////////// Update a Brewery ////////////////
	@Override
	public Brewery updateBrewery(Integer id, Brewery brewery) {
		Brewery mBrewery = em.find(Brewery.class, id);
		mBrewery.setName(brewery.getName());
		mBrewery.setAddress(brewery.getAddress());
		mBrewery.setImageUrl(brewery.getImageUrl());
		mBrewery.setLogo(brewery.getLogo());
		mBrewery.setBeer(brewery.getBeer());
		System.out.println(mBrewery);
		return mBrewery;
	}

}
