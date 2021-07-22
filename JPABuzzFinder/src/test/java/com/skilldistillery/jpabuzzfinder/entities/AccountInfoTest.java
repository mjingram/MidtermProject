package com.skilldistillery.jpabuzzfinder.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccountInfoTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private AccountInfo ai;

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
		ai = em.find(AccountInfo.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		ai = null;
		em.close();
	}

	@Test
	@DisplayName("testing accountInfo mapping")
	void test() {
		assertNotNull(ai);
		assertEquals("Paul", ai.getFirstName());
		assertEquals("Noodle", ai.getLastName());
	}
	
	@Test
	@DisplayName("testing accountInfo to address mapping")
	void test1() {
		assertNotNull(ai);
		assertEquals("Louisville", ai.getAddress().getCity());
		assertEquals(" KY", ai.getAddress().getState());
	}
	
	@Test
	@DisplayName("testing accountInfo to user mapping")
	void test2() {
		assertNotNull(ai);
		assertEquals("admin", ai.getUser().getUsername());
		assertEquals( 1, ai.getUser().getEnabled());
		
	}

}
