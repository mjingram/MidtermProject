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

class BreweryTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Brewery bt;

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
		bt = em.find(Brewery.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		bt = null;
		em.close();	
		}

	
	@Test
	@DisplayName("testing brewery mapping")
	void test() {
		assertNotNull(bt);
		assertEquals("NorthGate Brewing", bt.getName());
		
		/*SELECT * FROM brewery;
+----+-------------------+------------+-----------+----------------+
| id | name              | address_id | image_url | logo_image_url |
+----+-------------------+------------+-----------+----------------+
|  1 | NorthGate Brewing |          1 | NULL      | NULL           |
+----+-------------------+------------+-----------+----------------+
1 row in set (0.00 sec)
		 * 
		 * 
		 */
	}
	
	@Test
	@DisplayName("testing brewery to address mapping")
	void test1() {
		assertNotNull(bt);
		assertEquals("Minneapolis", bt.getAddress().getCity());
		assertEquals("MN", bt.getAddress().getState());
		assertEquals("55111", bt.getAddress().getZipcode());
	}
	
	

}
