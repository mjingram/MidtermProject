package com.skilldistillery.jpabuzzfinder.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BeerReviewTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private BeerReview br;

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
		br = em.find(BeerReview.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		br = null;
		em.close();
	}

	@Test
	@DisplayName("testing beer_review mapping")
	void test() {
		LocalDate reviewDate =  LocalDate.of(2020, 07, 13);
		assertNotNull(br);
		assertEquals("Wow, this beer sucks", br.getComment());
		assertEquals( reviewDate, br.getReviewDate());
	}
	
	@Test
	@DisplayName("testing beer_review to user mapping")
	void test1() {
		assertNotNull(br);
		assertEquals("admin", br.getUser().getUsername());
		assertEquals( 1, br.getUser().getEnabled());
	}
	
	@Test
	@DisplayName("testing beer_review to brewery mapping")
	void test2() {
		assertNotNull(br);
		assertEquals("Devil's Cup", br.getBeer().getName());
		assertEquals( 0.066, br.getBeer().getAbv());
		assertEquals( "NorthGate Brewing", br.getBeer().getBrewery().getName());
		
	}

}
