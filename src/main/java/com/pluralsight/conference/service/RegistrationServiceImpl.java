package com.pluralsight.conference.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.repository.RegisterRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	private RegisterRepository registerRepository;

	@Override
	@Transactional
	public Registration addRegistration(Registration registration) {
		return registerRepository.save(registration);
	}
	
}
