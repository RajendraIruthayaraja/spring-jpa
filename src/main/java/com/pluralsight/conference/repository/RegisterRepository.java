package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.Registration;

public interface RegisterRepository {

	Registration save(Registration registration);

}