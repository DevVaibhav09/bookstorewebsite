package org.bookstore.dao;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bookstore.entity.Users;
import org.junit.Test;

public class UserDaoTest {

	@Test
	public void testCreateUsers() {

		Users user1= new Users();
		user1.setFirstName("mahima");
		user1.setLastName("Bhatnagar");
		user1.setEmail("Vaibhavabc@abc.com");
		user1.setPassword("1234567890");
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("bookStroreWebsite");
		EntityManager entityManager = createEntityManagerFactory.createEntityManager();
		UserDao userDAO = new UserDao(entityManager);
		user1=userDAO.create(user1);
		entityManager.close();
		createEntityManagerFactory.close();
		assertTrue(user1.getUserId()>0);
	}
	
	@Test
	public void testgetUserDetails() {
		//Integer userId=1;
		//UserDao userDao = new UserDao(entityManager);	
				
	}

}
