package com.pluralsight.conference.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.model.RegistrationReport;

@Repository
public class RegisterRepositoryImpl implements RegisterRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Registration save(Registration registration) {
		entityManager.persist(registration);
		return registration;
	}

	@Override
	public List<Registration> findAll() {
		List<Registration> registration = entityManager.createQuery("Select r from Registration r").getResultList();
		return registration;
	}

	@Override
	public List<RegistrationReport> findAllReport() {
		
		//NAMED QUERIES WILL REPLACE THE BELOW COMMENTED CODE
		/*
		 * String jpql =
		 * "Select new com.pluralsight.conference.model.RegistrationReport" +
		 * "(r.name, c.name, c.description) " + "from Registration r, Course c " +
		 * "where r.id = c.registration.id";
		 * 
		 * List<RegistrationReport> registrationReport =
		 * entityManager.createQuery(jpql).getResultList();
		 */
		
		List<RegistrationReport> registrationReport = entityManager.createNamedQuery(Registration.REGISTRATION_REPORT).getResultList();
		return registrationReport;
	}
}
