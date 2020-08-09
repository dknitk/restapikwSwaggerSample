package com.kw.restapikw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.kw.restapikw.model.Person;
import com.kw.restapikw.services.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This rest controller helps to write REST API Controller.
 * 
 * @author dknitk
 *
 */
@RestController
@Api(tags = "Person RestAPI")
public class PersonRestController {
	
	private static final int SC_OK = 200;
	private static final int SC_BAD_REQUEST = 500;
	@Autowired
	PersonService personService;
			
	/**
	 * This method helps to retrieve the single person data.
	 * 
	 * @return List<Person>
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@GetMapping("/personObj")
	@ApiOperation(value = "Retrieves Person Information")
	@ApiResponses(value = { @ApiResponse(code = SC_OK, message = "ok"), 
	                        @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred") 
	                      })
	public List<Person> getPersonObjData() throws JsonParseException, JsonMappingException, IOException {		

		List<Person> persons = new ArrayList<Person>();
		
		persons.add(personService.getPersonJsonData());
		
		return persons;
	}
	
	/**
	 * This method helps to retrieve the multiple person data.
	 * 
	 * @return List<Person>
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@GetMapping("/personsObj")
	@ApiOperation(value = "Retrieves List of Person Information")
	@ApiResponses(value = { @ApiResponse(code = SC_OK, message = "ok"), 
	                        @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred") 
	                      })
	public List<Person> getPersonsObjData() throws JsonParseException, JsonMappingException, IOException {		

		return personService.getPersonJsonDataList();
	}

}
