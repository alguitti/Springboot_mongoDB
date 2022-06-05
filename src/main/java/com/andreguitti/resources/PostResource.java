package com.andreguitti.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andreguitti.domain.Post;
import com.andreguitti.resources.exception.util.URL;
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
	
	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	/*  /titlesearch?title="Bom%20dia  */
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		//List<Post> posts = service.findByTitle(text);
		List<Post> posts = service.searchTitle(text);
		return ResponseEntity.ok().body(posts);
		
	}
	
	@RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
	/*  /titlesearch?title="Bom%20dia  */
	public ResponseEntity<List<Post>> fullSearch(
				@RequestParam(value = "text", defaultValue = "") String text,
				@RequestParam(value = "minDate", defaultValue = "") String minDate,
				@RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date(0L));
		List<Post> posts = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(posts);
		
	}

}
