package com.pluralsight.conference.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pluralsight.conference.model.Registration;

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
}
