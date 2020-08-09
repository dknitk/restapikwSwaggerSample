package com.kw.restapikw.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kw.restapikw.model.Person;

/**
 * This service class helps to contain business logic.
 * 
 * @author dknitk
 *
 */
@Service
@EnableTransactionManagement
public class PersonServiceImpl implements PersonService {
	
	String jsonFilePath = "./src/main/resources/person_data.json";
	String jsonFilePathList = "./src/main/resources/person_dataList.json";

	/**
	 * This method helps to retrieve single object.
	 * 
	 */
	@Override
	public Person getPersonJsonData() throws JsonParseException, JsonMappingException, IOException {
		
		File file = new File(jsonFilePath);
		
		Person person = new Person();
		
		person = new ObjectMapper().readValue(file, Person.class);
		
		return person;
	}
	
	

	/**
	 * This method helps to retrieve multiple object.
	 * 
	 */
	@Override
	public List<Person> getPersonJsonDataList() throws JsonParseException, JsonMappingException, IOException {

		File file = new File(jsonFilePathList);		
		
		ObjectMapper mapper = new ObjectMapper();
		@SuppressWarnings("unchecked")
		List<Person> personList = (List<Person>) mapper.readValue(file, List.class);
		
		return personList;
	}
	
	
}
