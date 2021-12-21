package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.User;
import com.pluralsight.conference.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService; 
	
    @GetMapping("/user")
    public User getUser(@RequestParam(value = "firstname", defaultValue = "Rajendra") String firstname,
                        @RequestParam(value = "lastname", defaultValue = "Iruthayaraja") String lastname,
                        @RequestParam(value = "age", defaultValue = "33") int age) {
        User user = new User();

        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setAge(age);

        return user;
    }

    @PostMapping("/user")
    public User postUser(User user) {
        System.out.println("User firstname:" + user.getFirstname());
        userService.save(user);
        return user;
    }

}
