package com.example.spring.TodoApplication.Controller;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String username,String password) {
		 boolean validname=username.equalsIgnoreCase("Shiksha");
		 boolean validpass=password.equalsIgnoreCase("Aryan");
		 
		 return validname && validpass;
	}
}
