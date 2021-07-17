package com.skilldistillery.jpabuzzfinder.entities;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FavoriteStyleTest {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPABuzzFinder");
	private EntityManager em;
	private FavoriteStyle faveStyle;

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		faveStyle = em.find(FavoriteStyle.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		faveStyle = null;
	}

	@Test
	void test_beerStyle_mapping() {
		assertNotNull(faveStyle);
		
	}

}