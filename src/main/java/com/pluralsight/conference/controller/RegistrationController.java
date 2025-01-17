package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.model.RegistrationReport;
import com.pluralsight.conference.service.RegistrationService;

import antlr.collections.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@GetMapping("registration")
	public String getRegistration(@ModelAttribute("registration") Registration registration) {
		return "registration";
	}

	@GetMapping("registrations")
	public @ResponseBody java.util.List<Registration> getRegistrations() {

		java.util.List<Registration> registrations = registrationService.findAll();
		return registrations;
	}

	@GetMapping("registration-report")
	public @ResponseBody java.util.List<RegistrationReport> getRegistrationReport() {

		java.util.List<RegistrationReport> registrationReport = registrationService.findAllReport();

		return registrationReport;
	}

	@PostMapping("registration")
    public String addRegistration(@Valid @ModelAttribute ("registration")
                                              Registration registration,
                                  BindingResult result) {

        if(result.hasErrors()) {
            System.out.println("There were errors");
            return "registration";
        }else {
        	registrationService.addRegistration(registration);
        }

        System.out.println("Registration: " + registration.getName());

        return "redirect:registration";
    }

	@PostMapping("registration/update")
    public @ResponseBody Registration updtaeRegistration(@Valid @ModelAttribute("registration") 
    				Registration registration, BindingResult result ) {
		
		return registrationService.addRegistration(registration);
		
	}

}
