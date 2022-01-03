package com.pluralsight.conference.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pluralsight.conference.model.User;

//Commented this entire class,  because this implementation class has been replaced by extending the
//JPARepository in the UserRepository.Java class
/*
 * @Repository public class UserRepositoryImpl implements UserRepository {
 * 
 * @PersistenceContext private EntityManager entityManager;
 * 
 * @Override public User save(User user) {
 * 
 * entityManager.persist(user); return user;
 * 
 * }
 * 
 * }
 */