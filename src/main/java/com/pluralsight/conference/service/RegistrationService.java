package com.pluralsight.conference.service;

import javax.transaction.Transactional;

import com.pluralsight.conference.model.Registration;

public interface RegistrationService {

	Registration addRegistration(Registration registration);

}