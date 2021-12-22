package com.pluralsight.conference.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralsight.conference.model.Course;
import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.repository.CourseRepository;
import com.pluralsight.conference.repository.RegisterRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	private RegisterRepository registerRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	@Transactional
	public Registration addRegistration(Registration registration) {
		
		registration = registerRepository.save(registration);				
		
		Course course = new Course();
		course.setName("Intro Course");
		course.setDescription("Every Registered user must take this course");
		course.setRegistration(registration);
		courseRepository.save(course);
		
		return registration;
	}
	
}
