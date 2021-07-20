package com.skilldistillery.jpabuzzfinder.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpabuzzfinder.entities.Beer;
import com.skilldistillery.jpabuzzfinder.entities.Brewery;

@Service
@Transactional
public class BreweryDAOImpl implements BreweryDAO {

	@PersistenceContext
	private EntityManager em;
	private Brewery brewery;


///////////// Find Brewery By Id ////////////////
	

	@Override
	public List<Brewery> findAllBreweries() {
		String jpql = "SELECT b FROM Brewery b";
		List<Brewery> listAll = em.createQuery(jpql,Brewery.class).getResultList();
		return listAll;
	}
	
	
	@Override
	public Brewery findBreweryById(int id) {
		return em.find(Brewery.class, id);
	}
	
	
	@Override
	public Brewery findBreweryByName(String name) {
		List<Brewery> allBreweries = findAllBreweries();
		for(Brewery brewery: allBreweries) {
			if(brewery.getName().equals(name)) {
				return brewery;
			}
		}
		return brewery;
	}
	
	@Override
	public List<Brewery> findBreweryByLocation(String city, String state) {
		List<Brewery> breweries = findAllBreweries();
		for(Brewery brewery: breweries) {
			if(brewery.getAddress().getState().equals(state)
					&& brewery.getAddress().getCity().equals(city)) {
				breweries.add(brewery);
			}
		}
		return breweries;
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
