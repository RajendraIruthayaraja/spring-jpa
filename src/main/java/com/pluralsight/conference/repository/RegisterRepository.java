package com.pluralsight.conference.repository;

import java.util.List;

import com.pluralsight.conference.model.Registration;

public interface RegisterRepository {

	Registration save(Registration registration);

	List<Registration> findAll();

}