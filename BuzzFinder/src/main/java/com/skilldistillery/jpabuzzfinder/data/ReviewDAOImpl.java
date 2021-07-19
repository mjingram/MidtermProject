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
		
		List<BreweryReview> brews = null;
		
		BreweryReview b = em.find(BreweryReview.class, breweryId);
		 
		String jpql = "SELECT br FROM brewery_review br JOIN brewery ON  br.brewery_id = brewery.id WHERE br.brewery_id = ?";
		
		brews = em.createQuery(jpql, BreweryReview.class)
				.setParameter("brewery", b)
				.getResultList();
		
		return brews;
		}
	
//		List<BreweryReview> listById = em.createQuery(jpql, BreweryReview.class).getResultList();
//		
//		while (breweryId > 0) {
//		if(b != null) {
//			
//			brews = b.getBrewRev();
//			
//		}
//		 brews.size();
//		 em.close();

	@Override
	public List<BreweryReview> findByBrewery(Brewery brewery) {
		
		
		
		String jpql = "SELECT br FROM brewery_review br JOIN brewery ON br.brewery_id = brewery.id WHERE brewery.name =  ?";
		
		List<BreweryReview> listByName = em.createQuery(jpql, BreweryReview.class).getResultList();
		
		return listByName;
		
		
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
	public BeerReview findBeerId(int beerId) {

		return em.find(BeerReview.class, beerId);
	}

	@Override
	public BeerReview findByBeer(Beer beer) {

		return em.find(BeerReview.class, beer);
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
