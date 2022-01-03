package com.pluralsight.conference.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.model.RegistrationReport;

@Repository
public interface RegisterRepository extends JpaRepository<Registration, Long> {

	//Commenting because its already part of the JPARepository
	//Registration save(Registration registration);

	//Commenting because its already part of the JPARepository
	//List<Registration> findAll();

	//This is a Named query method(Customized), name of this method should be name of the named query in the Registration Pojo class 
	//and the Domain "Registration" has to be added to the name query
	List<RegistrationReport> registrationReport();

}