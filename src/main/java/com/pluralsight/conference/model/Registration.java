package com.pluralsight.conference.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "REGISTRATION")
@NamedQueries({
	@NamedQuery(name=Registration.REGISTRATION_REPORT,query = Registration.REGISTRATION_REPORT_JPQL)
})
public class Registration {

	//This is for the named query and the jpql is formed based upon projection to display only the required object to the front end
	public static final String REGISTRATION_REPORT = "Registration.registrationReport";
	public static final String REGISTRATION_REPORT_JPQL = "Select new com.pluralsight.conference.model.RegistrationReport"
			+ "(r.name, c.name, c.description) " + "from Registration r, Course c " + "where r.id = c.registration.id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String name;

	@JsonManagedReference
	@OneToMany(mappedBy = "registration", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Course> courses = new ArrayList<>();

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
