package com.integrationTestCase.templateController;



import java.util.ArrayList;
import java.util.List;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

import com.integrationTestCase.model.Person;

@Controller
public class ReportTemplate {
	
	final String uri = "http://localhost:8080/";
	
	@RequestMapping(value="/report", method=RequestMethod.GET)
	public String showTemplateReport(ModelMap model) {
		
		RestTemplate restTemplate =new RestTemplate();
		ResponseEntity<List<Person>> response = restTemplate.exchange(	uri+"/persona/obtener",
																		HttpMethod.GET,
																		null, 
																		new ParameterizedTypeReference<List<Person>>(){} );
		List<Person> list = response.getBody();
		System.out.println("Total Person : "+ list.size());
		model.addAttribute("personList",list);
		model.addAttribute("total",list.size());
		return "report";
	}
	
	@RequestMapping(value="/report", method=RequestMethod.POST)
	public String findPerson(WebRequest request, ModelMap model) {
		int personId = Integer.parseInt(request.getParameter("personId"));
		
		RestTemplate restTemplate =new RestTemplate();
		ResponseEntity<Person> response = restTemplate.exchange(	uri+"/persona/obtener/"+personId,
																	HttpMethod.GET,
																	null, 
																	new ParameterizedTypeReference<Person>(){} );
		
		System.out.println(response);
		List<Person> list = new ArrayList<Person>();
		if(response!=null) {
			list.add(response.getBody());
		}
		
		System.out.println("Total Person : "+ list.size());
		model.addAttribute("personList",list);
		model.addAttribute("total",list.size());
		return "report";
		
	}

}
