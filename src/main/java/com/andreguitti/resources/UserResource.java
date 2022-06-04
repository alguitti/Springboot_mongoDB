package com.andreguitti.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	//@RequestBody atribui o atributo recebido com o corpo da mensagem Json
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> insert (@RequestBody UserDTO objDto) {
		User user = service.insert(objDto.fromDTO());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build(); //código 204 nada retorna
	}
}
