package com.example.spring.TodoApplication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	private AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value="login", method = RequestMethod.GET)
	public String goToLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String WelcomePage(@RequestParam String name,@RequestParam String password, ModelMap model ) {
		model.put("name", name);
		
		if(authenticationService.authenticate(name, password)) {
		return "welcome";
	}
		else {
			model.put("error","Invalid Credentials! Better luck next time.");
			return "login";}
}
}