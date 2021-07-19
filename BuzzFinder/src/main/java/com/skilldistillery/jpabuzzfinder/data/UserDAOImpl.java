package com.skilldistillery.jpabuzzfinder.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpabuzzfinder.entities.User;

@Service
@Transactional
public class UserDAOImpl implements UserDAO{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPABuzzFinder");
	
	@PersistenceContext
	private EntityManager em;

	
	public User create(User user) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Before persit: " + user);
		em.persist(user);
		System.out.println("After persit: " + user);

		em.flush();
		em.getTransaction().commit();
		em.close();

		return user;

	}
	
	public User updateById(int id, User user) {
		EntityManager em = emf.createEntityManager();
		User updated = em.find(User.class, id);
		System.out.println("Before update: "+ updated);
		
		em.getTransaction().begin();
		
		updated.setUsername(user.getUsername());
		updated.setPassword(user.getPassword());
		
		em.flush();
		em.getTransaction().commit();
		
		System.out.println("After update: "+ updated);
		em.close();
		
		return updated;
		
	}
	
	public User updateByUsername(String username, User user) {
		EntityManager em = emf.createEntityManager();
		User updated = em.find(User.class, username);
		System.out.println("Before update: "+ updated);
		
		em.getTransaction().begin();
		
		updated.setUsername(user.getUsername());
		updated.setPassword(user.getPassword());
		
		em.flush();
		em.getTransaction().commit();
		
		System.out.println("After update: "+ updated);
		em.close();
		
		return updated;
		
	}
	
	public boolean destroyById(int id) {
		EntityManager em = emf.createEntityManager();
		User removedUser = em.find(User.class, id);
		
		em.getTransaction().begin();
		
		em.remove(removedUser);
		boolean success = !em.contains(removedUser);
		
		em.getTransaction().commit();
		em.close();
		
		return success;
		
	}
	
	@Override
	public User findById(int id) {
		User user = em.find(User.class, id);
		return user;
	}
	
	public User findByUsername(String username) {
		User user = em.find(User.class, username);
		return user;
	}
}
