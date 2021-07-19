package com.skilldistillery.jpabuzzfinder.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpabuzzfinder.entities.Beer;
import com.skilldistillery.jpabuzzfinder.entities.BeerReview;
import com.skilldistillery.jpabuzzfinder.entities.Brewery;
import com.skilldistillery.jpabuzzfinder.entities.BreweryReview;

@Service
@Transactional
public class ReviewDAOImpl implements ReviewDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<BreweryReview> findByBreweryId(BreweryReview brewRev, int breweryId) {

		List<BreweryReview> breweries = null;

		String jpql = "SELECT br FROM brewery_review br JOIN brewery ON br.brewery_id = brewery.id WHERE br.brewery_id = :brewery";

		breweries = em.createQuery(jpql, BreweryReview.class).setParameter("brewery", breweryId).getResultList();

		return breweries;

	}

	@Override
	public List<BreweryReview> findByBrewery(Brewery brewery) {

		List<BreweryReview> brews = null;

		String jpql = "SELECT br FROM brewery_review br JOIN brewery ON br.brewery_id = brewery.id WHERE brewery.name = :brewery";

		brews = em.createQuery(jpql, BreweryReview.class).setParameter("brewery", brewery).getResultList();

		return brews;

	}

	@Override
	public BreweryReview addBrewComment(BreweryReview brewRev) {
		em.persist(brewRev);
		return brewRev;
	}

	@Override
	public BreweryReview editBrewComment(BreweryReview brewRev, int id) {
		BreweryReview editCom = em.find(BreweryReview.class, id);

		editCom.setComment(brewRev.getComment());

		return editCom;
	}

	@Override
	public boolean deleteBrewComment(BreweryReview brewRev) {
		BreweryReview deleteRev = em.find(BreweryReview.class, brewRev);

		em.remove(deleteRev);

		boolean deleteDone = !em.contains(deleteRev);

		return deleteDone;
	}

	@Override
	public List<BeerReview> findByBeerId(int beerId) {

		List<BeerReview> beers = null;

		String jpql = "SELECT br FROM beer_review br JOIN beer ON br.beer_id = beer.id WHERE br.beer_id = :beer";

		beers = em.createQuery(jpql, BeerReview.class)
				.setParameter("beer", beerId)
				.getResultList();

		return beers;
	}

	@Override
	public List<BeerReview> findByBeer(Beer beer) {

		List<BeerReview> beers = null;

		String jpql = "SELECT br FROM beer_review br JOIN beer ON br.beer_id = beer.id WHERE beer.name = :beer";

		beers = em.createQuery(jpql, BeerReview.class)
				.setParameter("beer", beer)
				.getResultList();

		return beers;
	}

	@Override
	public String addBeerComment(String beerRev) {
		em.persist(beerRev);
		return beerRev;
	}

	@Override
	public BeerReview editBeerComment(BeerReview beRev, int id) {
		BeerReview editCom = em.find(BeerReview.class, id);

		editCom.setComment(beRev.getComment());

		return editCom;
	}

	@Override
	public boolean deleteBeerComment(BeerReview beRev) {
		BeerReview deleteRev = em.find(BeerReview.class, beRev);

		em.remove(deleteRev);

		boolean deleteDone = !em.contains(deleteRev);

		return deleteDone;
	}

}
