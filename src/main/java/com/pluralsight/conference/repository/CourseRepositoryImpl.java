package com.pluralsight.conference.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pluralsight.conference.model.Course;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Course save(Course course) {
		
		entityManager.persist(course);
		return course;
		
	}
}
