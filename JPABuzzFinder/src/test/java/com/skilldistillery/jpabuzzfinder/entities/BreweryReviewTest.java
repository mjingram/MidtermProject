package com.skilldistillery.jpabuzzfinder.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

class BreweryReviewTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private BreweryReview br;

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
		br = em.find(BreweryReview.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		br = null;
		em.close();
	}

	@Test
	@DisplayName("testing brewery_review mapping")
	void test() {
		LocalDate reviewDate =  LocalDate.of(2021, 07, 12);
		assertNotNull(br);
		assertEquals("This is the bestest brewery eva!", br.getComment());
		assertEquals( reviewDate, br.getReviewDate());
	}
	
	@Test
	@DisplayName("testing brewery_review to user mapping")
	void test1() {
		assertNotNull(br);
		assertEquals("admin", br.getUser().getUsername());
		assertEquals( 1, br.getUser().getEnabled());
	}
	
	@Test
	@DisplayName("testing brewery_review to brewery mapping")
	void test2() {
		assertNotNull(br);
		assertEquals("Against the Grain Brewery", br.getBrewery().getName());
		assertEquals( "Louisville", br.getBrewery().getAddress().getCity());
		
	}

}
