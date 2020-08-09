package com.kw.restapikw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.kw.restapikw.model.Person;
import com.kw.restapikw.services.PersonService;

import io.swagger.annotations.Api;

@Controller
@Api(tags = "Person Controller API")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@RequestMapping(value = { "/person" }, method = RequestMethod.GET)
	public ModelAndView getPersonData() throws JsonParseException, JsonMappingException, IOException {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("person");
		modelAndView.addObject("person", personService.getPersonJsonData());
		
		return modelAndView;
	}
	
	@RequestMapping(value = { "/persons" }, method = RequestMethod.GET)
	public ModelAndView searchPerson() throws JsonParseException, JsonMappingException, IOException {
		
		ModelAndView modelAndView = new ModelAndView();
		
		List<Person> persons = new ArrayList<Person>();
		
		persons = personService.getPersonJsonDataList();
		
		modelAndView.setViewName("personList");
		
		modelAndView.addObject("persons", persons);
		
		return modelAndView;
	}

}
