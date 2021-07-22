package com.skilldistillery.jpabuzzfinder.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpabuzzfinder.entities.Brewery;
import com.skilldistillery.jpabuzzfinder.entities.User;

@Service
@Transactional
public class BreweryDAOImpl implements BreweryDAO {

	@PersistenceContext
	private EntityManager em;
	private Brewery brewery;

	private List<Brewery> faveBreweries = new ArrayList<>();

///////////// Find Brewery By Id ////////////////

	@Override
	public List<Brewery> findAllBreweries() {
		String jpql = "SELECT b FROM Brewery b";
		List<Brewery> listAll = em.createQuery(jpql, Brewery.class).getResultList();
		return listAll;
	}

	@Override
	public Brewery findBreweryById(int id) {
		return em.find(Brewery.class, id);
	}

	@Override
	public List<Brewery> findBreweryByName(String name) {
//		String jpql = "SELECT b FROM Brewery b WHERE b.name = :name";
//		List<Brewery> breweries = em.createQuery(jpql, Brewery.class).setParameter("name", name).getResultList();
		
		String jpql = "SELECT b FROM Brewery b WHERE b.name LIKE :name";
		List<Brewery> breweries = em.createQuery(jpql, Brewery.class)
				.setParameter("name", "%" + name + "%").getResultList();


		if (breweries.size() > 0) {
			return breweries;
		}

		return breweries;

	}

	@Override
	public List<Brewery> findBreweryByLocation(String city, String state) {

		String jpql = "SELECT b FROM Brewery b JOIN Address a "
//				+ "ON b.address.id = a.id WHERE a.city = :city AND a.state = :state";
//		List<Brewery> breweries = em.createQuery(jpql, Brewery.class).setParameter("city", city)
//				.setParameter("state", state).getResultList();

				+ "ON b.address.id = a.id WHERE a.city LIKE :city AND a.state LIKE :state";
		List<Brewery> breweries = em.createQuery(jpql, Brewery.class)
				.setParameter("city", "%" + city + "%").setParameter("state", "%" + state + "%")
				.getResultList();

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

///////// Add Brewery to Favorites List //////
	@Override
	public List<Brewery> addToFavoriteList(Integer userId, int id) {
		User user = em.find(User.class, userId);
		Brewery brewery = em.find(Brewery.class, id);
		if(user.getFavBreweries().contains(brewery)) {
			return faveBreweries;
		}
		else {
		user.addFavBrewery(brewery);
		faveBreweries = user.getFavBreweries();
		return faveBreweries;
		}
	}
	
	
	@Override
	public List<Brewery> removeFavoriteBrewery(int id){
		Brewery brewery = em.find(Brewery.class, id);
		faveBreweries.remove(brewery);
		return faveBreweries;
	}

}
