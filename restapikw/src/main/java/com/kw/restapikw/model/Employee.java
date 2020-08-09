package com.kw.restapikw.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Employee {
	
	@JsonInclude(content = Include.NON_NULL)
	
	@JsonPropertyOrder({	
		"id",
		"firstName",
		"lastName",
		"gender",
		"address"
		
	})	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("middleName")
	private String middleName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("supervisor")
	private String supervisor;
	
	
	

}
