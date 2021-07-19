package com.skilldistillery.jpabuzzfinder.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpabuzzfinder.entities.Beer;
import com.skilldistillery.jpabuzzfinder.entities.BeerReview;
import com.skilldistillery.jpabuzzfinder.entities.BeerStyle;
import com.skilldistillery.jpabuzzfinder.entities.Brewery;
import com.skilldistillery.jpabuzzfinder.entities.BreweryReview;
import com.skilldistillery.jpabuzzfinder.entities.User;

@Service
@Transactional
public class UserDAOImpl implements UserDAO{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPABuzzFinder");
	
	@PersistenceContext
	private EntityManager em;

	
	public User createUser(User user) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(user);

		em.flush();
		em.getTransaction().commit();
		em.close();

		return user;

	}
	
	
	public User updateUsernameAndPassword(String password, User user) {
		EntityManager em = emf.createEntityManager();
		User updated = em.find(User.class, user);
		System.out.println("Before update: "+ updated);
		
		em.getTransaction().begin();
		if(user.getPassword().equals(password)) {
			
			updated.setUsername(user.getUsername());
			updated.setPassword(user.getPassword());
		}
		
		em.flush();
		em.getTransaction().commit();
		
		System.out.println("After update: "+ updated);
		em.close();
		
		return updated;
		
	}
	
	
	public boolean deleteUser(User user) {
		EntityManager em = emf.createEntityManager();
		
		User removedUser = em.find(User.class, user);
		
		em.getTransaction().begin();
		
		em.remove(removedUser);
		boolean success = !em.contains(removedUser);
		
		em.getTransaction().commit();
		em.close();
		
		return success;
		
	}
	
	
	public User login(String username, String password) {
		User user = null;
		if(em.find(User.class, username).getPassword().equals(password) 
				&& em.find(User.class, username).getUsername().equals(username)) {
			user = em.find(User.class, username);	
		}
		
		return user;
		
	}
	
	
	public Beer addFavBeer(User user, Beer beer) {
		EntityManager em = emf.createEntityManager();
		
		Beer newBeer = em.find(Beer.class, beer);
		
		em.getTransaction().begin();
		user.addFavBeer(newBeer);
		
		em.flush();
		em.getTransaction().commit();
		
		em.close();
		
		return newBeer;
		
	}
	
	
	public Brewery addFavBrewery(User user, Brewery brewery) {
		EntityManager em = emf.createEntityManager();

		Brewery newFavBrewery = em.find(Brewery.class, brewery);
		
		em.getTransaction().begin();
		user.addFavBrewery(newFavBrewery);

		em.flush();
		em.getTransaction().commit();
		em.close();

		return newFavBrewery;
		
	}
	
	
		public BreweryReview addBreweryReview(User user, BreweryReview breweryReview) {
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			user.addBreweryReview(breweryReview);
			
			em.flush();
			em.getTransaction().commit();
			em.close();
			
			return breweryReview;

	}
		
		
		public BeerReview addBeerReview(User user, BeerReview beerReview) {
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			user.addBeerReview(beerReview);
			
			em.flush();
			em.getTransaction().commit();
			em.close();
			
			return beerReview;
			
		}
		
		public User updateFavBeerStyle(BeerStyle bs, User user) {
			EntityManager em = emf.createEntityManager();
			
			User updated = em.find(User.class, user);
			
			em.getTransaction().begin();
				
			updated.setFavoriteStyle(bs);
			
			
			em.flush();
			em.getTransaction().commit();
			
			em.close();
			
			return updated;
			
		}
		
		public boolean removeFavBeer(User user, Beer beer) {
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			user.removeBeerFromFavs(beer);
			boolean success = !em.contains(user.getFavoriteBeers().contains(beer));
			
			em.getTransaction().commit();
			em.close();
			
			return success;
			
		}
		
		public boolean removeFavBrewery(User user, Brewery brewery) {
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			user.removeBreweryFromFavs(brewery);
			boolean success = !em.contains(user.getFavoriteBreweries().contains(brewery));
			
			em.getTransaction().commit();
			em.close();
			
			return success;
			
		}
		
		public boolean removeBeerReview(User user, BeerReview beerReview) {
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			user.removeBeerReview(beerReview);
			boolean success = !em.contains(user.getBeerReviews().contains(beerReview));
			
			em.getTransaction().commit();
			em.close();
			
			return success;
			
		}
		
		
		public boolean removeBreweryReview(User user, BreweryReview breweryReview) {
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			user.removeBreweryReview(breweryReview);
			boolean success = !em.contains(user.getBreweryReviews().contains(breweryReview));
			
			em.getTransaction().commit();
			em.close();
			
			return success;
			
		}
		
		public List<BeerReview> updateBeerReview(BeerReview beerReview, User user) {
			EntityManager em = emf.createEntityManager();
			
			List<BeerReview> reviews = user.getBeerReviews();
			em.getTransaction().begin();
			
			user.addBeerReview(beerReview);
			
			em.flush();
			em.getTransaction().commit();
			reviews.add(beerReview);
			
			em.close();
			
			return reviews;
			
		}
		
		public List<BreweryReview> updateBreweryReview(BreweryReview breweryReview, User user) {
			EntityManager em = emf.createEntityManager();
			
			List<BreweryReview> reviews = user.getBreweryReviews();
			em.getTransaction().begin();
			
			user.addBreweryReview(breweryReview);
			
			em.flush();
			em.getTransaction().commit();
			reviews.add(breweryReview);
			
			em.close();
			
			return reviews;
			
		}
}
