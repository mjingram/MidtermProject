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

class BeerTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Beer beer;

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
		beer = em.find(Beer.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		beer = null;
		em.close();
	}

	@Test
	@DisplayName("testing beer mapping")
	void testName() {
		assertNotNull(beer);
		assertEquals("Dale's Pale Ale", beer.getName());
	}
	
	@Test
	@DisplayName("testing beer to brewery mapping")
	void testBeerToBrew() {
		assertNotNull(beer);
		assertEquals("Oskar Blues Brewery", beer.getBrewery().getName());
		assertEquals(166 , beer.getBrewery().getId());
	}
	
	@Test
	@DisplayName("testing beer to beer style mapping")
	void testBeerToStyle() {
		assertNotNull(beer);
		assertEquals("American Pale Ale (APA)", beer.getBeerStyle().getName());
		assertEquals(18 , beer.getBeerStyle().getId());
	}

}
