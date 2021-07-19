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
	
//	public User updateById(int id, User user) {
//		EntityManager em = emf.createEntityManager();
//		User updated = em.find(User.class, id);
//		System.out.println("Before update: "+ updated);
//		
//		em.getTransaction().begin();
//		
//		updated.setUsername(user.getUsername());
//		updated.setPassword(user.getPassword());
//		
//		em.flush();
//		em.getTransaction().commit();
//		
//		System.out.println("After update: "+ updated);
//		em.close();
//		
//		return updated;
//		
//	}
	
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
	
	public boolean destroyByUsername(String username, String password) {
		EntityManager em = emf.createEntityManager();
		
		User removedUser = em.find(User.class, username);
		
		em.getTransaction().begin();
		if(em.find(User.class, username).getPassword().equals(password) 
				&& em.find(User.class, username).getUsername().equals(username)) {
		em.remove(removedUser);
		}
		boolean success = !em.contains(removedUser);
		
		em.getTransaction().commit();
		em.close();
		
		return success;
		
	}
	
//	@Override
//	public User findById(int uid) {
//		User user = em.find(User.class, uid);
//		return user;
//	}
	
	public User login(String username, String password) {
		User user = null;
		if(em.find(User.class, username).getPassword().equals(password) 
				&& em.find(User.class, username).getUsername().equals(username)) {
			user = em.find(User.class, username);	
		}
		
		return user;
	}
}
