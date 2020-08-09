package com.kw.restapikw.services;

import org.springframework.stereotype.Service;

/**
 * This class helps to maintain the user.
 * 
 * @author dknitk
 *
 */
@Service
public class HelloServiceImpl implements UserService {

	@Override
	public String getHelloWorld() {
		return "Hello World!";
	}

	
}