package com.andreguitti.resources;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andreguitti.domain.User;
import com.andreguitti.dto.UserDTO;
import com.andreguitti.services.UserService;

@RestController //declara que é um recurso REST
@RequestMapping(value="/users") //caminho do Endpoint na 8080
public class UserResource {
	
	@Autowired
	private UserService service;
	
	//ou @GetMapping
	@RequestMapping(method = RequestMethod.GET) //declara que vai ser um endpoint com metodo GET
	public ResponseEntity<List<UserDTO>> findAll() {
		
		//User obj1 = new User(null, "Maria", "maria@maria");
		//User obj2 = new User(null, "Alex", "alex@alex");
		
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		//ok() resposta HTTP 200
		//body() corpo da resposta
		
	}
	
	//pathvariable diz que o Id da URL casa com o atributo recebido
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		UserDTO uDTO = new UserDTO(service.findById(id));
		return ResponseEntity.ok().body(uDTO);
	}
	
	
}
