package com.integrationTestCase.templateController;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

import com.integrationTestCase.model.Person;

@Controller
public class RegistrationTemplate {
	final String uri = "http://localhost:8080/";

	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String showTemplateHome(Model model) {
		return "registration";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String addUser(WebRequest request, ModelMap model) {
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		if(name==null || name=="" && lastname==null || lastname=="") {
			model.addAttribute("message","Please fill all the fields.");
			return "registration";
		}
		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Person> myRequest = new HttpEntity<>(new Person(name,lastname));
		ResponseEntity<Boolean> response = restTemplate.exchange(uri+"persona/guardar", HttpMethod.POST, myRequest, Boolean.class);
        Boolean result = response.getBody();
        if(result) {
        	System.out.println("Saved ");
        	model.addAttribute("message","The person is saved");
        } else {
        	System.out.println("Error");
        	model.addAttribute("message","Please fill all the fields.");
        }
		return "registration";
	}
}
