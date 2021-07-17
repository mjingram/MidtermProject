package com.skilldistillery.jpabuzzfinder.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BeerStyleTest {
private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPABuzzFinder");
private EntityManager em;
private BeerStyle beerStyle;


	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		beerStyle = em.find(BeerStyle.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		beerStyle = null;
	}

	@Test
	void test_beerStyle_mapping() {
		assertNotNull(beerStyle);
		assertEquals("India Pale Ale", beerStyle.getName());
	}
	@Test
	void test_beerlist_mapping() {
		assertNotNull(beerStyle.getBeers());
		assertTrue(beerStyle.getBeers().size() > 0);
	}

}
