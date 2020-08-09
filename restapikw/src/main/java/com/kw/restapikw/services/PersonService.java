package com.kw.restapikw.services;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.kw.restapikw.model.Person;

public interface PersonService {
	
	public Person getPersonJsonData() throws JsonParseException, JsonMappingException, IOException;
	
	public List<Person> getPersonJsonDataList() throws JsonParseException, JsonMappingException, IOException;

}
