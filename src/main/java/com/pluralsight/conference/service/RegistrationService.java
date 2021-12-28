package com.pluralsight.conference.service;

import java.util.List;

import javax.transaction.Transactional;

import com.pluralsight.conference.model.Registration;

public interface RegistrationService {

	Registration addRegistration(Registration registration);

	List<Registration> findAll();

}