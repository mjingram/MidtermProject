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
	
	private List<BeerReview> beerReviews = new ArrayList<>();

	
	@Override
	public List<BreweryReview> findReviewByBreweryId(int breweryId) {

		List<BreweryReview> breweries = null;

		String jpql = "SELECT br FROM BreweryReview br WHERE br.brewery.id = :brewery";

		breweries = em.createQuery(jpql, BreweryReview.class).setParameter("brewery", breweryId).getResultList();

		return breweries;

	}

	@Override
	public List<BreweryReview> findReviewByBrewery(Brewery brewery) {

		List<BreweryReview> brews = null;

		String jpql = "SELECT br FROM BreweryReview br WHERE br.brewery = :brewery";

		brews = em.createQuery(jpql, BreweryReview.class).setParameter("brewery", brewery).getResultList();

		return brews;

	}

	@Override
	public BreweryReview addBreweryReview(BreweryReview brewRev) {
		em.persist(brewRev);
		return brewRev;
	}

	@Override
	public BreweryReview editBreweryReview(BreweryReview brewRev, int id) {
		BreweryReview editCom = em.find(BreweryReview.class, id);

		editCom.setComment(brewRev.getComment());

		return editCom;
	}

	@Override
	public boolean deleteBreweryReview(int reviewId) {
		BreweryReview deleteRev = em.find(BreweryReview.class, reviewId);

		em.remove(deleteRev);

		boolean deleteDone = !em.contains(deleteRev);

		return deleteDone;
	}

	@Override
	public List<BeerReview> findReviewByBeerId(int beerId) {

		List<BeerReview> beers = null;

		String jpql = "SELECT br FROM BeerReview br WHERE br.beer.id = :beer";

		beers = em.createQuery(jpql, BeerReview.class)
				.setParameter("beer", beerId)
				.getResultList();

		return beers;
	}

	@Override
	public List<BeerReview> findReviewByBeer(Beer beer) {

		List<BeerReview> beers = null;

		String jpql = "SELECT br FROM BeerReview br WHERE br.beer = :beer";

		beers = em.createQuery(jpql, BeerReview.class)
				.setParameter("beer", beer)
				.getResultList();

		return beers;
	}

	@Override
	public BeerReview addBeerReview(BeerReview beerRev) {
		em.persist(beerRev);
		return beerRev;
	}

	@Override
	public BeerReview editBeerReview(BeerReview beRev, int id) {
		BeerReview editCom = em.find(BeerReview.class, id);

		editCom.setComment(beRev.getComment());

		return editCom;
	}

	@Override
	public boolean deleteBeerReview(int beerId) {
		BeerReview deleteRev = em.find(BeerReview.class, beerId);

		em.remove(deleteRev);

		boolean deleteDone = !em.contains(deleteRev);

		return deleteDone;
	}

}
