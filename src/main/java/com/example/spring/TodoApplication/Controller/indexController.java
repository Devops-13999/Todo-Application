package com.example.spring.TodoApplication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class indexController {
	
	@RequestMapping("salute")
	public String salutation() {
		return "salute";
	}
	

}
