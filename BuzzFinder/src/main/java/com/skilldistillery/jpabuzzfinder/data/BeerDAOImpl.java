package com.skilldistillery.jpabuzzfinder.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpabuzzfinder.entities.Beer;
import com.skilldistillery.jpabuzzfinder.entities.BeerStyle;


@Service
@Transactional
public class BeerDAOImpl implements BeerDAO {
	
	@PersistenceContext
	private EntityManager em;
	private Beer beer;

	
	@Override
	public Beer findBeerById(int id) {
		
		return em.find(Beer.class, id);
	}

	
	@Override
	public Beer findBeerByName(String name) {
		List<Beer> beers = findAllBeers();
		for(Beer beer: beers) {
			if(beer.getName().equals(name)) {
				return beer;
			}
		}
		return beer;
	
	}

	
	@Override
	public List<Beer> findBeerByStyle(BeerStyle beerStyle) {
		List<Beer> beers = findAllBeers();
		for(Beer beer: beers) {
			if(beer.getBeerStyle().equals(beerStyle)) {
				beers.add(beer);
			}
			}
			return beers;
	}

	
	@Override
	public List<Beer> findAllBeers() {
		String jpql = "SELECT b FROM Beer b";
		List<Beer> listAll = em.createQuery(jpql,Beer.class).getResultList();
		return listAll;
	}

	
	@Override
	public Beer addBeerToProfile(Beer beer) {
		em.persist(beer);
		return beer;
	}

	
	@Override
	public Beer updateBeerProfile(Beer beer) {
		Beer beerdb = em.find(Beer.class, beer.getId());
		
		beerdb.setName(beer.getName());
		beerdb.setBrewery(beer.getBrewery());
		beerdb.setBeerStyle(beer.getBeerStyle());
		beerdb.setAbv(beer.getAbv());
		beerdb.setIbu(beer.getIbu());
		beerdb.setOunces(beer.getOunces());
		
		em.flush();
		
		return beerdb;
	}

	
	@Override
	public boolean deleteBeerFromProfile(int id) {
		
		Beer deleteBeer = em.find(Beer.class, id);
		
		em.remove(deleteBeer);
		
		boolean deleteDone = !em.contains(deleteBeer);
		
		return deleteDone;
	}

}
