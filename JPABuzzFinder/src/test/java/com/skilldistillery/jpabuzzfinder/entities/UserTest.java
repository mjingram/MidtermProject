package com.skilldistillery.jpabuzzfinder.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPABuzzFinder");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		user = null;
		em.close();
	}

	@Test
	@DisplayName("testing user mapping")
	void test() {
		assertNotNull(user);
		assertEquals("admin", user.getUsername());
		assertEquals( 1, user.getEnabled());
	}
	
	@Test
	@DisplayName("testing user to beer style mapping")
	void test1() {
		assertNotNull(user);
		assertEquals("India Pale Ale", user.getFavoriteStyle().getName());
	}
	
	@Test
	@DisplayName("testing user to beer mapping")
	void test2() {
		assertNotNull(user);
		assertEquals(1, user.getFavoriteBeers().size());
	}
	
	@Test
	@DisplayName("testing user to brewery mapping")
	void test3() {
		assertNotNull(user);
		assertEquals(1, user.getFavoriteBreweries().size());
	}
	
	

}
