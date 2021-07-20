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
	
	public User findById(int id) {
		User user = em.find(User.class, id);
		return user;
	}
	
	public User updateUsernameAndPassword(String password, int userId) {
		EntityManager em = emf.createEntityManager();
		User updated = em.find(User.class, userId);
		System.out.println("Before update: "+ updated);
		
		em.getTransaction().begin();
		if(updated.getPassword().equals(password)) {
			
			updated.setUsername(updated.getUsername());
			updated.setPassword(updated.getPassword());
		}
		
		em.flush();
		em.getTransaction().commit();
		
		System.out.println("After update: "+ updated);
		em.close();
		
		return updated;
		
	}
	
	
	public boolean deleteUser(int userId) {
		EntityManager em = emf.createEntityManager();
		
		User removedUser = em.find(User.class, userId);
		
		em.getTransaction().begin();
		
		em.remove(removedUser);
		boolean success = !em.contains(removedUser);
		
		em.getTransaction().commit();
		em.close();
		
		return success;
		
	}
	
	
	public User login(String username, String password) {
		User user = null;
		String jpql = "SELECT u FROM User u WHERE u.username = :name AND u.password = :password";
		
		List<User> users = em.createQuery(jpql, User.class).
		setParameter("name", username).
		setParameter("password", password).
		getResultList();
		
		if(users.size() == 1) {
			user = users.get(0);
		}
		
		return user;
		
	}
	
	
	
	public Beer addFavBeer(int userId, Beer beer) {
		EntityManager em = emf.createEntityManager();
		User user = em.find(User.class, userId);
		
		em.getTransaction().begin();
		user.addFavBeer(beer);
		
		em.flush();
		em.getTransaction().commit();
		
		em.close();
		
		return beer;
		
	}
	
	
	public Brewery addFavBrewery(int userId, Brewery brewery) {
		EntityManager em = emf.createEntityManager();

		User user = em.find(User.class, userId);
		
		em.getTransaction().begin();
		user.addFavBrewery(brewery);

		em.flush();
		em.getTransaction().commit();
		em.close();

		return brewery;
		
	}
	
	
		public BreweryReview addBreweryReview(int userId, BreweryReview breweryReview) {
			EntityManager em = emf.createEntityManager();
			
			User user = em.find(User.class, userId);
			em.getTransaction().begin();
			
			user.addBreweryReview(breweryReview);
			
			em.flush();
			em.getTransaction().commit();
			em.close();
			
			return breweryReview;

	}
		
		
		public BeerReview addBeerReview(int userId, BeerReview beerReview) {
			EntityManager em = emf.createEntityManager();
			
			User user = em.find(User.class, userId);
			em.getTransaction().begin();
			
			user.addBeerReview(beerReview);
			em.flush();
			
			em.getTransaction().commit();
			em.close();
			
			return beerReview;
			
		}
		
		public User updateFavBeerStyle(int userId, BeerStyle bs) {
			EntityManager em = emf.createEntityManager();
			
			User updated = em.find(User.class, userId);
			
			em.getTransaction().begin();
				
			updated.setFavoriteStyle(bs);
			
			
			em.flush();
			em.getTransaction().commit();
			
			em.close();
			
			return updated;
			
		}
		
		public boolean removeFavBeer(int userId, Beer beer) {
			EntityManager em = emf.createEntityManager();
			
			User user = em.find(User.class, userId);
			em.getTransaction().begin();
			
			user.removeBeerFromFavs(beer);
			boolean success = !em.contains(user.getFavoriteBeers().contains(beer));
			
			em.getTransaction().commit();
			em.close();
			
			return success;
			
		}
		
		public boolean removeFavBrewery(int userId, Brewery brewery) {
			EntityManager em = emf.createEntityManager();
			
			User user = em.find(User.class, userId);
			em.getTransaction().begin();
			
			user.removeBreweryFromFavs(brewery);
			boolean success = !em.contains(user.getFavoriteBreweries().contains(brewery));
			
			em.getTransaction().commit();
			em.close();
			
			return success;
			
		}
		
		public boolean removeBeerReview(int userId, BeerReview beerReview) {
			EntityManager em = emf.createEntityManager();
			
			User user = em.find(User.class, userId);
			em.getTransaction().begin();
			
			user.removeBeerReview(beerReview);
			boolean success = !em.contains(user.getBeerReviews().contains(beerReview));
			
			em.getTransaction().commit();
			em.close();
			
			return success;
			
		}
		
		
		public boolean removeBreweryReview(int userId, BreweryReview breweryReview) {
			EntityManager em = emf.createEntityManager();
			
			User user = em.find(User.class, userId);
			em.getTransaction().begin();
			
			user.removeBreweryReview(breweryReview);
			boolean success = !em.contains(user.getBreweryReviews().contains(breweryReview));
			
			em.getTransaction().commit();
			em.close();
			
			return success;
			
		}
		
		public List<BeerReview> updateBeerReviews(int userId, BeerReview beerReview) {
			EntityManager em = emf.createEntityManager();
			
			User user = em.find(User.class, userId);
			List<BeerReview> reviews = user.getBeerReviews();
			em.getTransaction().begin();
			
			user.addBeerReview(beerReview);
			
			em.flush();
			em.getTransaction().commit();
			reviews.add(beerReview);
			
			em.close();
			
			return reviews;
			
		}
		
		public List<BreweryReview> updateBreweryReviews(int userId, BreweryReview breweryReview) {
			EntityManager em = emf.createEntityManager();
			
			User user = em.find(User.class, userId);
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
