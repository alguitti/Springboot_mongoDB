package com.andreguitti.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andreguitti.domain.Post;
import com.andreguitti.services.PostService;

@RestController //declara que é um recurso REST
@RequestMapping(value="/posts") //caminho do Endpoint na 8080
public class PostResource {
	
	@Autowired
	private PostService service;
	
	//ou @GetMapping
	@RequestMapping(method = RequestMethod.GET) //declara que vai ser um endpoint com metodo GET
	public ResponseEntity<List<Post>> findAll() {
		
		//User obj1 = new User(null, "Maria", "maria@maria");
		//User obj2 = new User(null, "Alex", "alex@alex");
		
		List<Post> list = service.findAll();
		return ResponseEntity.ok().body(list);
		//ok() resposta HTTP 200
		//body() corpo da resposta
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)	
	public ResponseEntity<Post> findById(@PathVariable String id) {
		
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
		
	}

	
	
}
