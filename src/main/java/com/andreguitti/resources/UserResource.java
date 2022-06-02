package com.andreguitti.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andreguitti.domain.User;
import com.andreguitti.services.UserService;

@RestController //declara que é um recurso REST
@RequestMapping(value="/users") //caminho do Endpoint na 8080
public class UserResource {
	
	@Autowired
	private UserService service;
	
	//ou @GetMapping
	@RequestMapping(method = RequestMethod.GET) //declara que vai ser um endpoint com metodo GET
	public ResponseEntity<List<User>> findAll() {
		
		//User obj1 = new User(null, "Maria", "maria@maria");
		//User obj2 = new User(null, "Alex", "alex@alex");
		
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
		//ok() resposta HTTP 200
		//body() corpo da resposta
		
	}
	
	
}
